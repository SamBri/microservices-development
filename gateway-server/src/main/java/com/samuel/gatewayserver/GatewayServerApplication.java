package com.samuel.gatewayserver;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
	}

	
	// custom gateway routing configuration
	@Bean
	public RouteLocator comSamuelRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {

		return routeLocatorBuilder.routes()
				.route(p -> p.path("/samuel/users/**")
						.filters(f -> f.rewritePath("/samuel/users/(?<segement>.*)", "/${segement}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
								).uri("lb://USERS"))
				.route(p -> p.path("/samuel/transactions/**")
						.filters(f -> f.rewritePath("/samuel/transactions/(?<segement>.*)", "/${segement}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
								)
						.uri("lb://TRANSACTIONS"))
				.build();

	}
	
	
	
}
