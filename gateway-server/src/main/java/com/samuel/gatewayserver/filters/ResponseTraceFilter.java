package com.samuel.gatewayserver.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.publisher.Mono;

//write filter :: cross-cutting, tracing...
@Configuration // find beans 
public class ResponseTraceFilter  {

	
	@Autowired
	FilterUtility filterUtility; // filiter util object
	
	
	@Bean // create a spring bean object :: it is a global filter object
	public GlobalFilter postGlobalFilter() {
		
		
	 return (exchange, chain)-> {
		 
		 
		 
		 return chain.filter(exchange).then(Mono.fromRunnable(()->{
			 
			 // request sent , result of response received from ms
			 
			 // look into the http request message.
			 
			 // transform for response
			String correlationId = null;
			 
			 exchange.getResponse().getHeaders().add("", correlationId);

			 
			 
		 }));
	 };
	 
	}
		
	
	
	
	
	
	
}
