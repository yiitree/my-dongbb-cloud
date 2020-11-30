package com.zimug.congbb.cloud.server.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ZimugServerEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZimugServerEurekaApplication.class, args);
	}

}
