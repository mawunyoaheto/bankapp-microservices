package com.raymond.cloudgateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {
//    @Bean
//    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(r -> r.path("/customers/**")
//                        .uri("lb://customer-service")
//                        .id("customersService"))
//
//                .route(r -> r.path("/accounts/**")
//                        .uri("lb://account-service")
//                        .id("accountsService"))
//                .build();
//    }
}
