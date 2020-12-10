package com.zimug.dongbb.cloud.server.gateway;

import com.alibaba.csp.sentinel.adapter.spring.webflux.callback.WebFluxCallbackManager;
import io.netty.handler.codec.http.HttpMethod;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;

import java.util.Arrays;

@SpringBootApplication
public class ZimugServerGatewayApplication {

	public static void main(String[] args) {
        // 自定义限流相应处理
        WebFluxCallbackManager.setBlockHandler(new MySentinelBlockHandler());
		SpringApplication.run(ZimugServerGatewayApplication.class, args);
	}


	// 方式二：编码方式实现路由
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("zimug-blog", r -> r.path("/category/**")
				//.and().method(HttpMethod.GET)
				//.or().host("192.168.1.4")
				.uri("http://zimug.com"))
				.build();
	}

    /**
     * 跨域配置，允许跨域，之后在服务中就不需要添加了
     * @return
     */
    @Bean
    public CorsWebFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedMethods(Arrays.asList(
                HttpMethod.POST.name(),
                HttpMethod.GET.name()
        ));
        config.addAllowedOrigin("Http://localhost:8080");
        config.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource source
                = new UrlBasedCorsConfigurationSource(new PathPatternParser());
        source.registerCorsConfiguration("/**", config);

        return new CorsWebFilter(source);
    }
}
