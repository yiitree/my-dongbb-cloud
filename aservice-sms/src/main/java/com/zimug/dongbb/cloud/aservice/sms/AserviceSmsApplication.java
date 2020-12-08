package com.zimug.dongbb.cloud.aservice.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication(scanBasePackages={"com.zimug.dongbb.cloud"})
// 启动eureka客户端
@EnableEurekaClient
// 服务熔断
@EnableCircuitBreaker
public class AserviceSmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AserviceSmsApplication.class, args);
    }

}
