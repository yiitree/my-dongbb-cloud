package com.zimug.dongbb.cloud.aservice.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.zimug.dongbb.cloud"})
public class AserviceSmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AserviceSmsApplication.class, args);
	}

}
