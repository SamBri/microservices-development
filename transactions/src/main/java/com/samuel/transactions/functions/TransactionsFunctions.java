package com.samuel.transactions.functions;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.samuel.transactions.dto.UserDto;

@Configuration
public class TransactionsFunctions {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionsFunctions.class);	


//	@Bean // the consumer
//	public Consumer<FulfilmentDto> updateNotification(){
//		
//		
//		
//		return (e) -> {
//			
//			LOGGER.info("@@@ inside updateNotification");
//
//		
//			LOGGER.info("@@@ the response {} "
//					+ "from the send-communication exchange binding queue", e );
//			
//			
//			
//			
//		};
//		
//		
//	}
	
	
	@Bean // the consumer
	public Consumer<UserDto> updateNotification(){
		
		
		
		return (e) -> {
			
			LOGGER.info("@@@ inside updateNotification");

		
			LOGGER.info("@@@ the response {} "
					+ "from the send-communication exchange binding queue", e );
			
			
			
			
		};
		
		
	}

}
