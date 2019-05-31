package com.itf.schulung.BankingApp.Controller;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itf.schulung.BankingApp.model.Account;
import com.itf.schulung.BankingApp.model.Transaction;
import com.itf.schulung.BankingApp.repositories.AccountRepository;
import com.itf.schulung.BankingApp.repositories.TransactionRepository;

@RestController
public class TransactionController {

	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
	private TransactionRepository transactionRepo;
	
	@CrossOrigin(origins="*",allowedHeaders="*")
	@GetMapping(value = "/transaction/{originIbanId}/{destinationIbanId}/{amount}")
	public Transaction transfer(
			@PathVariable String originIbanId, 
			@PathVariable String destinationIbanId, 
			@PathVariable Long amount) {
		
		Optional<Account> optionalOrigin = accountRepo.findByIban(originIbanId); //Optional<Account> verhindert NullPointerException
		Optional<Account> optionalDesti = accountRepo.findByIban(destinationIbanId);
		Transaction trans = new Transaction();
		
		if(optionalOrigin.isPresent() && optionalDesti.isPresent()) {
			Account origin = optionalOrigin.get();
			Account dest = optionalDesti.get();
			double urBalance = origin.getBalance();
			try {
				trans.setOrigin(origin);   // muss stehen, falls Fehler bei der Transaktion auftreten, dass kein Geld verloren geht
				trans.setDestination(dest);
				trans.setAmount(amount);			
				origin.withdraw(amount);
				dest.deposit(amount);				
			} catch(Exception e) {
				if(origin.getBalance() != urBalance) {
					origin.deposit(origin.getBalance()-urBalance);
				}
									
			} finally {
				accountRepo.save(origin);
				accountRepo.save(dest);
			}
		} else {
			// keine Accounts gefunden
		}
		
		transactionRepo.save(trans);
		return trans;
	}
	
	private int getRandomTan() {
		int tan = 10000 + new Random().nextInt(90000);
		return tan;
	}
}
