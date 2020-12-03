package com.zimug.dongbb.cloud.server.scconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class ConfigServerWebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 开通权限否则通过“/actuator/bus-refresh”访问将会报错：401，没有权限访问。
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 都是无状态请求，不需要session，节省资源
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);
        //关闭csrf跨站请求防御
        http.csrf().disable();
        // 所有的请求必须登录认证后才能访问
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }
}
