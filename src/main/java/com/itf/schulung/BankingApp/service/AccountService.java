package com.itf.schulung.BankingApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itf.schulung.BankingApp.model.Account;
import com.itf.schulung.BankingApp.repositories.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepo;
	
	
	public List<Account> getAllAccounts(){
		return accountRepo.findAll();
	}
	
	public void createAccount(Account account) {
		accountRepo.save(account);
	}
}
