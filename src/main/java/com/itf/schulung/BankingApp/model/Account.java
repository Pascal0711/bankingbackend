package com.itf.schulung.BankingApp.model;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String iban;
	
	private double balance = 0.0;
	
	private String accountType;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	@JsonIgnore
	private Customer customer;
	
	public Account() {}
	
	Account(Long id, double balance, String iban, String accountType) {
		this.id = id;
		this.balance = balance;
		this.iban = iban;
		this.accountType = accountType;
	}
	
	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public long getAccountId() {
		return id;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void deposit(double amount) {
		this.balance = this.balance + amount;
	}
	
	public void withdraw(double amount) {
		this.balance = this.balance - amount;
	}

}
