package com.samuel.transactions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samuel.transactions.entity.Transaction;

@Repository // my dao
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
