package com.zimug.dongbb.cloud.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
// 开启熔断监控
@EnableHystrixDashboard
public class ZimugServerHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZimugServerHystrixDashboardApplication.class, args);
	}

}
