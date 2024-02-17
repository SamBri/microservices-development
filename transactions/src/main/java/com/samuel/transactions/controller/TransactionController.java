package com.samuel.transactions.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.samuel.transactions.dto.TransactionDto;
import com.samuel.transactions.dto.UserDto;
import com.samuel.transactions.exception.TransactionExecutionException;
import com.samuel.transactions.response.RootResponse;
import com.samuel.transactions.service.ITransactionService;
import com.samuel.transactions.service.clients.User;
import com.samuel.transactions.service.clients.UserFeignClient;
import com.samuel.transactions.utils.ITransactionUtil;
import com.samuel.transactions.utils.TransactionUtil;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);

	@Autowired
	ITransactionService transactionService;
	
	@Autowired
	ITransactionUtil transactionUtil;

	@Autowired
	UserFeignClient userFeignClient;

	@PostMapping("")
	public ResponseEntity<RootResponse<TransactionDto>> createTransaction(@RequestBody TransactionDto request) {

		TransactionDto transactionDto = new TransactionDto();
		RootResponse<TransactionDto> rootResponse = new RootResponse<TransactionDto>();
		try {

			LOGGER.info("@@@@  user {} is generating transaction", request.getUserId());

			LOGGER.info("The transaction request sent by user {}", new ObjectMapper().writeValueAsString(request));

			transactionDto = transactionService.generateTransaction(request);

			if (transactionDto == null) {

				LOGGER.info("inside failed to generate transaction");

				
				rootResponse = new RootResponse<TransactionDto>("error", "-400", "Transaction failed.", transactionDto);

			} else {

				LOGGER.info("inside success generation of transaction");

				
				rootResponse = new RootResponse<TransactionDto>("success", "200", "Transaction generated",
						transactionDto);

				ResponseEntity<RootResponse<User>> userMsResponse = userFeignClient
						.fetchUserByUserId(Integer.valueOf(request.getUserId())); // get UserContactId from User
																					// microservices

				String contactId = userMsResponse.hasBody() ? userMsResponse.getBody().getResponse().getMobileNumber()
						: null;

				UserDto userDto = new UserDto(request.getUserId(), contactId, request.getTransactionId());

				// send notification
				Object response = transactionUtil.sendNotification(userDto);

				LOGGER.info("the status of the notification request, {}", response);

			}

		} catch (Exception e) {
			
			LOGGER.error("exception generated executing generate transaction", e);

			throw new TransactionExecutionException(e.getMessage());

		}

		return new ResponseEntity<RootResponse<TransactionDto>>(rootResponse, HttpStatus.CREATED);

	}

}
