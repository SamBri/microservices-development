package com.samuel.transactions.service;

import com.samuel.transactions.dto.TransactionDto;
import com.samuel.transactions.dto.TransactionResponseDto;

public interface ITransactionService {
	
	TransactionDto generateTransaction(TransactionDto transactionDto);

}
