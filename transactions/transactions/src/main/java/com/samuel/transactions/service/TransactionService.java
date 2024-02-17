package com.samuel.transactions.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.samuel.transactions.controller.TransactionController;
import com.samuel.transactions.dto.TransactionDto;
import com.samuel.transactions.dto.TransactionResponseDto;
import com.samuel.transactions.entity.Transaction;
import com.samuel.transactions.repository.TransactionRepository;

@Service
public class TransactionService implements ITransactionService {

	private final TransactionRepository transactionRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionService.class);


	// inject the repository
	public TransactionService(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}

	@Override
	public TransactionDto generateTransaction(TransactionDto transactionDto) {

		
		LOGGER.info("@@@ persisting the generated transaction");
		
		Transaction theGeneratedTransaction = new Transaction();
		theGeneratedTransaction.setTransactionId(transactionDto.getTransactionId());
		theGeneratedTransaction.setUserId(transactionDto.getUserId());
		theGeneratedTransaction.setAmount(transactionDto.getAmount());
		
	   theGeneratedTransaction = transactionRepository.save(theGeneratedTransaction);
		
	   return new TransactionDto(theGeneratedTransaction.getUserId(),
			   theGeneratedTransaction.getTransactionId(),theGeneratedTransaction.getAmount());
		
		
		
	}
	
	
	

}
