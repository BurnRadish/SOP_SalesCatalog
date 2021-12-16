package com.example.gatewayservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@Configuration
public class GatewayConfig {
    @Autowired
    AuthenticationFilter filter;
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder){
        return builder.routes()
                .route("personal-data-service", r -> r.path("/information/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://personal-data-service")
                )
                .route("auth-service", r -> r.path("/auth/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://auth-service")
                )
                .route("history-service", r -> r.path("/history/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://history-service")
                )
                .route("product-service", r -> r.path("/product/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://product-service")
                )
                .build();
    }
}
