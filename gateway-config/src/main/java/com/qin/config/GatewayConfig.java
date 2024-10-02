package com.qin.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("github_route", ps -> ps.path("/github")
                        .uri("https://github.com"))
                .route("header_route", ps -> ps.header("X-Request-Id", "\\d+")
                        .or()
                        .header("Color", "gr.+")
                        .uri("https://toutiao.com")
                )
                .build();
    }
}
