# Start all backend services as background jobs and write logs
param()

$root = Split-Path -Parent $MyInvocation.MyCommand.Path
$services = @(
    @{ name = 'eureka'; path = Join-Path $root '..\eureka-server'; port=8761 },
    @{ name = 'config'; path = Join-Path $root '..\config-server'; port=8888; env = @{ 'SPRING_PROFILES_ACTIVE' = 'native' } },
    @{ name = 'maintenance'; path = Join-Path $root '..\maintenance-service'; port=8084 },
    @{ name = 'surveillance'; path = Join-Path $root '..\surveillance-service'; port=8087 },
    @{ name = 'notification'; path = Join-Path $root '..\notification-service'; port=8085 },
    @{ name = 'gateway'; path = Join-Path $root '..\api-gateway'; port=8082 }
)

$logsDir = Join-Path $root '..\logs'
if (-Not (Test-Path $logsDir)) { New-Item -Path $logsDir -ItemType Directory | Out-Null }

Write-Host "Killing existing java processes..."
Get-Process java -ErrorAction SilentlyContinue | Stop-Process -Force -ErrorAction SilentlyContinue
Start-Sleep -Seconds 2

foreach ($s in $services) {
    $log = Join-Path $logsDir ("{0}.log" -f $s.name)
    Write-Host "Starting $($s.name) -> $($s.path) (log: $log)"
    $envBlock = $null
    if ($s.ContainsKey('env')) { $envBlock = $s.env }

    Start-Job -Name ("job_$($s.name)") -ArgumentList $s.path,$log,$envBlock -ScriptBlock {
        param($svcPath,$logFile,$envHash)
        Push-Location $svcPath
        if ($envHash -ne $null) {
            foreach ($k in $envHash.Keys) { $env:$k = $envHash[$k] }
        }
        # Run mvnw.cmd and redirect both stdout and stderr to log file
        & .\mvnw.cmd spring-boot:run *> $logFile
        Pop-Location
    } | Out-Null
    Start-Sleep -Seconds 4
}

Write-Host "All jobs started. Wait 12s for services to boot, then check health endpoints manually or use the check-health script."