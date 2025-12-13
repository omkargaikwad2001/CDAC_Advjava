package com.example.demo.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

	@Bean
	public RouteLocator createRoutes(RouteLocatorBuilder builder) {

		return builder.routes().route("P7_SpringBootService1", r -> r.path("/user/**")
//                        .uri("lb://P7_SpringBootService1"))
				.uri("http://localhost:8081"))
				
				.route("P7_SpringBootService2", r -> r.path("/admin/**")
//                        .uri("lb://P7_SpringBootService2"))
						.uri("http://localhost:8082"))
				.build();
	}
}
