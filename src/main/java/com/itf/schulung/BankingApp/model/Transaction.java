package com.itf.schulung.BankingApp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToOne
	private Account origin;
	@OneToOne
	private Account destination;
	private double amount;
	
	public Transaction() {}
	
	public Transaction(Account origin, Account destination, double amount) {
		this.origin = origin;
		this.destination = destination;
		this.amount = amount;		
	}
	
	@OneToMany(cascade=CascadeType.ALL)
	List<Account> accounts;

	public Account getDestination() {
		return destination;
	}

	public void setDestination(Account destination) {
		this.destination = destination;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Account getOrigin() {
		return origin;
	}

	public void setOrigin(Account origin) {
		this.origin = origin;
	}
	

}
	
	
