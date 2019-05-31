package com.itf.schulung.BankingApp.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itf.schulung.BankingApp.model.Account;
import com.itf.schulung.BankingApp.model.Adresse;
import com.itf.schulung.BankingApp.repositories.AccountRepository;

@RestController
public class AccountController {
	
	@Autowired
	private AccountRepository accountRepo;
	
	@GetMapping(value = "/account/{id}")
	public Account welcomeAccount(@PathVariable long id) {
		Optional<Account> account = accountRepo.findById(id);
		if (account.isPresent()) {
			return account.get(); 
		}
		return null;
	}
	
	 @PostMapping(value = "/account")
	  Account newAccount(@RequestBody Account newAccount) {
	    return accountRepo.save(newAccount);
	  }
	
	@PutMapping(value = "/account/{id}")
	Account replaceAccount(@RequestBody Account newAccount, @PathVariable Long id) {
	
	return accountRepo.findById(id)
		.map(account -> {
			account.setIban(newAccount.getIban());
			account.setBalance(newAccount.getBalance());
			account.setAccountType(newAccount.getAccountType());
			return accountRepo.save(account);
	})
	.orElseGet(() -> {
	newAccount.setId(id);
	return accountRepo.save(newAccount);
	});
	}
	
	@DeleteMapping("/account/{id}")
	void deleteAccount(@PathVariable Long id) {
	accountRepo.deleteById(id);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(value="/account", produces="application/json") 
	public List<Account> showAccountList(Model model) {
		return accountRepo.findAll();
	}

}
