package com.itf.schulung.BankingApp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.itf.schulung.BankingApp.model.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

}
