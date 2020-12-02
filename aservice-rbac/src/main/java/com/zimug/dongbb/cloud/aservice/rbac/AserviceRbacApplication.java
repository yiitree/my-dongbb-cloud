package com.zimug.dongbb.cloud.aservice.rbac;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import feign.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication(
        scanBasePackages={"com.zimug.dongbb.cloud"},
        exclude = {SecurityAutoConfiguration.class}
)
@MapperScan(basePackages = {"com.zimug.dongbb.cloud.**.mapper"})
// 相关功能会放到网关中，aservice-rbac中将spring security的安全认证自动配置功能排除掉（不生效）
//@EnableAutoConfiguration(exclude = {
//		SecurityAutoConfiguration.class
//})
// 服务发现，只针对eureka客户端
//@EnableEurekaClient
// 服务发现，通用方式，其他注册中心也可以用
@EnableDiscoveryClient
// 开启openFeign远程调用
@EnableFeignClients
// 启动apollo
@EnableApolloConfig
public class AserviceRbacApplication {

	public static void main(String[] args) {
		SpringApplication.run(AserviceRbacApplication.class, args);
	}

    /**
     * 加密bean
     * @return
     */
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

    /**
     * openFeign日志 然后再在配置类（比如主程序入口类）中加入Looger.Level的Bean
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

}
