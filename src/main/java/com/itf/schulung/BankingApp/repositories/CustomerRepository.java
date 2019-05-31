package com.itf.schulung.BankingApp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.itf.schulung.BankingApp.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findAll ();
	Customer findAccountById(int accountId);
}
