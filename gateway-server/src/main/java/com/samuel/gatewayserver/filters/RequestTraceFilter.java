package com.samuel.gatewayserver.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;


//@Order(1)
@Component // it is a spring bean of type GlobalFilter :: sync with spring 
public class RequestTraceFilter implements GlobalFilter {
	
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

		
		// enough.
		
		
		return  chain.filter(exchange);
	}


}
