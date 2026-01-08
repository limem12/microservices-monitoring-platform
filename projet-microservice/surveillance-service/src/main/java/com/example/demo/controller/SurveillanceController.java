package com.example.demo.controller;

import com.example.demo.entity.MesureAnalyse;
import com.example.demo.service.SurveillanceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/surveillance")
public class SurveillanceController {

    private final SurveillanceService surveillanceService;

    public SurveillanceController(SurveillanceService surveillanceService) {
        this.surveillanceService = surveillanceService;
    }

    @PostMapping("/mesures")
    public MesureAnalyse analyser(@RequestBody MesureAnalyse mesure) {
        return surveillanceService.analyserMesure(mesure);
    }
}
