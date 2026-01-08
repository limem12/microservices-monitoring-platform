package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.context.config.annotation.RefreshScope;
@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigServer
@RefreshScope
public class ServeurDeConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServeurDeConfigurationApplication.class, args);
	}

}
