package com.itf.schulung.BankingApp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.itf.schulung.BankingApp.model.Adresse;


@Repository
public interface AdresseRepository extends CrudRepository<Adresse, Long> {

	List<Adresse> findAll();
	Adresse findAccountById(int accountId);
	}


