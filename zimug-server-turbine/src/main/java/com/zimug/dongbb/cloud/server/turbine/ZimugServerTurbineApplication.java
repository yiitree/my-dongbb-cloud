package com.zimug.dongbb.cloud.server.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableTurbine
@SpringBootApplication
public class ZimugServerTurbineApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZimugServerTurbineApplication.class, args);
	}

}
