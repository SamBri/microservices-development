package com.samuel.transactions.entity;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Transaction schema
@Entity
@Table(name = "transactions")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id; // record tracking
	
	@Column(name = "TRANSACTION_ID")
	private String transactionId; // transaction tracking 
	
	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "TRANSACTION_TYPE", nullable = true)
	private String transactionType; // what type of transaction came to the gateway.
	
	@Column(name = "TRANSACTION_SOURCE", nullable = true)
	private String transactionSource; // source of transaction;
	
	@CreationTimestamp
	@Column(name = "TRANSACTION_DATE")
	private String transactionDate; // the date transaction took effect.
	
	@Column(name = "AMOUNT", nullable = false)
	private Double amount; // amount of the transaction
	
	
	@Column(name = "CREATED_BY", nullable = true)
	private String createdBy; // who created the transaction.

//	private String createdAt; // the date the transaction was created.
//	private String modifiedBy; // who modified the transaction.
//	private String modifiedAt; // time transaction was modified.
//	
	
	
	
	

}
