package com.samuel.message.functions;

import java.util.function.Function;

import javax.print.attribute.standard.MediaSize.Other;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.samuel.message.dto.FulfilmentDto;
import com.samuel.message.dto.UserDto;



@Configuration
public class MessageFunctions {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageFunctions.class);	
	
	// processor send sms.
	@Bean
	public Function<UserDto, UserDto> sms(){
		
		// what should this processor do.
		return (e) -> {
			
			LOGGER.info("@@@@@ sending sms");
			return e ;
			
		};
	}
	
	
	// processor deliver to whatsapp
	@Bean
	public Function<UserDto, FulfilmentDto> whatsapp(){
		
		// what should this processor do.
		return (e) -> {
			
			LOGGER.info("@@@@@ sending whatsapp notification");
			FulfilmentDto fDto = new FulfilmentDto(e.userId(), e.transactionId(), "Success");
			return fDto ;
			
		};
	}
	
	
	
	
//	@Bean
//	public Function<FulfilmentDto, FulfilmentDto> other(){
//		
//		// what should this processor do.
//		return (e) -> {
//			
//			LOGGER.info("@@@@@ sending whatsapp notification");
//			FulfilmentDto fDto = new FulfilmentDto(e.userId(), e.transactionId(), "Success");
//			return fDto ;
//			
//		};
//	}
	
	
	// processor send email
	@Bean
	public Function<UserDto, UserDto> email(){
		
		// what should this processor do.
		return (e) -> {
			
			LOGGER.info("@@@@@ sending email");
			return e ;
			
		};
	}
	
	
	public static void main(String args[]) {
		
		
		
		
		
		
	
	}
	
	

}
