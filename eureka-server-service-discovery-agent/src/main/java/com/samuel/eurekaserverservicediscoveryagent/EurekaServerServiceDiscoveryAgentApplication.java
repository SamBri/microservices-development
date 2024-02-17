package com.samuel.eurekaserverservicediscoveryagent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // enable eureka server
public class EurekaServerServiceDiscoveryAgentApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerServiceDiscoveryAgentApplication.class, args);
	}

}
