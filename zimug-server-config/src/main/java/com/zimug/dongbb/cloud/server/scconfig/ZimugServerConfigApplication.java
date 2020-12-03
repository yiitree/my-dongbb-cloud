package com.zimug.dongbb.cloud.server.scconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

// 开启eureka
@EnableEurekaClient
// 开启SpringCloudConfig
@EnableConfigServer
@SpringBootApplication
public class ZimugServerConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZimugServerConfigApplication.class, args);
	}

}
