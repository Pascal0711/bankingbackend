package com.itf.schulung.BankingApp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.itf.schulung.BankingApp.model.Account;

//Crud: Create, Read, update, delete
@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
	
	List<Account> findAll();
	Optional<Account> findByIban(String iban);
	Account findAccountById(int accountId);
}
