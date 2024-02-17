package com.samuel.transactions.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

import com.samuel.transactions.dto.UserDto;


@Component
public class TransactionUtil implements ITransactionUtil {

	private final static Logger LOGGER = LoggerFactory.getLogger(TransactionUtil.class);
	
	@Autowired
	private   StreamBridge streamBridge;
	
	
	
	public  Object sendNotification(UserDto userDto) {
		
		LOGGER.info("sending notification message {} event to the broker", userDto);
		// produce the message from this application to the destination bindings, of what exchange | out
		
		//var sendPayload = userDto;
		
	   Object response	= streamBridge.send("sendNotification-out-0", userDto);
		
		LOGGER.info("response from the broker, {}", response);

	   
		return response;
	}
	
	
	
	

}
