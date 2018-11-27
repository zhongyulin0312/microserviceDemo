package com.gateway.main.Interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 网关配置
 */
@Configuration
public class ApiGatewayConfig {

    @Bean
    public PermissionFilter permissionFilter(){
        return new PermissionFilter();
    }
}
