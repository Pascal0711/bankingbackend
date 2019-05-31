	package com.itf.schulung.BankingApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.itf.schulung.BankingApp.repositories.CustomerRepository;

@SpringBootApplication
public class BankingAppApplication implements CommandLineRunner {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(BankingAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//generationService.generateAndSaveRandomCustomers(5000);
		System.out.println("count customer repo " + customerRepo.count());
		
	}
}
