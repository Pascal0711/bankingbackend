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
//import com.itf.schulung.BankingApp.factory.CustomerFactory;
import com.itf.schulung.BankingApp.model.Customer;
import com.itf.schulung.BankingApp.repositories.AccountRepository;
import com.itf.schulung.BankingApp.repositories.AdresseRepository;
import com.itf.schulung.BankingApp.repositories.CustomerRepository;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private AdresseRepository adressRepo;
	
	@Autowired
	private AccountRepository accountRepo;
	
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/customer/{id}")
	public Customer welcomeCustomer(@PathVariable long id) {
		Optional<Customer> customer = customerRepo.findById(id);
		if (customer.isPresent()) {
			return customer.get(); 
		}
		return null;
	}
	
	 @PostMapping(value = "/customer")
	 public Customer newCustomer(@RequestBody Customer newCustomer) {
		adressRepo.save(newCustomer.getAdresse());
		accountRepo.saveAll(newCustomer.getAccount());
	    return customerRepo.save(newCustomer);
	  }
	
	 @CrossOrigin(origins = "*")
	 @DeleteMapping(value="/customer/{id}")
	 public void deleteCustomer(@PathVariable long id) {
		 customerRepo.delete(customerRepo.findById(id).get());
	 }
	 
	@PutMapping(value = "/customer/{id}")
	Customer replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {
	
	return customerRepo.findById(id) // Vorausgesetzt mit der richtigen ID!!!
		.map(customer -> {
			customer.setCustomerPreName(newCustomer.getCustomerPreName());
			customer.setCustomerLastName(newCustomer.getCustomerLastName());
			customer.setAddress(newCustomer.getAdresse());
			return customerRepo.save(customer);
	})
	.orElseGet(() -> {
	newCustomer.setId(id);
	return customerRepo.save(newCustomer);
	});
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(value="/customer", produces="application/json") 
	public List<Customer> showCustomerList(Model model) {
		return customerRepo.findAll();
	}
	
	@PostMapping(value ="/customer/{id}/adresse")
	public void changeAdress(@PathVariable Long customerId,@RequestBody Adresse newAdress) {
		Optional<Customer> optCust = customerRepo.findById(customerId);
		if(optCust.isPresent()) {
			Customer customer = optCust.get();
			customer.setAddress(newAdress);
			customerRepo.save(customer);
		}
	}

}

//@GetMapping(value="/customer") 
//public String showCustomerId() {
//	return "a"; 
//}

//@GetMapping(value= "/")
//public String home() {	
//	return "home";
//}

//@GetMapping(value= "/customerAdresse")
//public String schowCustomersAdresse() {
//	return "adresses";
//}
