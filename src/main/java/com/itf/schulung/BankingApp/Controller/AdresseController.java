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
import com.itf.schulung.BankingApp.repositories.AdresseRepository;

@RestController
public class AdresseController {
	
	@Autowired
	private AdresseRepository adresseRepo;
	
	@GetMapping(value = "/adresse/{id}")
	public Adresse welcomeAdresse(@PathVariable long id) {
		Optional<Adresse> adresse = adresseRepo.findById(id);
		if (adresse.isPresent()) {
			return adresse.get(); 
		}
		return null;
	}
	
	 @PostMapping(value = "/adresse")
	  Adresse newAdresse(@RequestBody Adresse newAdresse) {
	    return adresseRepo.save(newAdresse);
	  }
	
	@PutMapping(value = "/adresse/{id}")
	Adresse replaceAdresse(@RequestBody Adresse newAdresse, @PathVariable Long id) {
	
	return adresseRepo.findById(id)
		.map(adresse -> {
			adresse.setStreetName(newAdresse.getStreetName());
			adresse.setStreetNumber(newAdresse.getStreetNumber());
			adresse.setPostalCode(newAdresse.getPostalCode());
			adresse.setCity(newAdresse.getCity());
			adresse.setCountry(newAdresse.getCountry());
			return adresseRepo.save(adresse);
	})
	.orElseGet(() -> {
	newAdresse.setId(id);
	return adresseRepo.save(newAdresse);
	});
	}
	
	@DeleteMapping("/adresse/{id}")
	void deleteAdresse(@PathVariable Long id) {
	adresseRepo.deleteById(id);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(value="/adresse", produces="application/json") 
	public List<Adresse> showAdresseList(Model model) {
		return adresseRepo.findAll();
	}

}
