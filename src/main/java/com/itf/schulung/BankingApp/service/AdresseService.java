package com.itf.schulung.BankingApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itf.schulung.BankingApp.model.Account;
import com.itf.schulung.BankingApp.model.Adresse;
import com.itf.schulung.BankingApp.repositories.AccountRepository;
import com.itf.schulung.BankingApp.repositories.AdresseRepository;

@Service
public class AdresseService {

	@Autowired
	private AdresseRepository adresseRepo;
	
	
	public List<Adresse> getAllAdresses(){
		return adresseRepo.findAll();
	}
	
	public void createAdresse(Adresse adresse) {
		adresseRepo.save(adresse);
	}
}
