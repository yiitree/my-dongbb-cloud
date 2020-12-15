package com.zimug.dongbb.cloud.aservice.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication(scanBasePackages={"com.zimug.dongbb.cloud"})
//@SpringBootApplication
// 启动eureka客户端
//@EnableEurekaClient
// 服务发现，通用方式，其他注册中心也可以用
@EnableDiscoveryClient
public class AserviceSmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AserviceSmsApplication.class, args);
    }

}
