package com.itf.schulung.BankingApp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
		
	@NotNull
	private String customerPreName;
	
	@NotNull
	private String customerLastName;		
		
	
	@OneToMany(mappedBy = "customer", cascade=CascadeType.ALL)
	List<Account> accounts;
	
	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name = "adresse_id", nullable = false)
	private Adresse adresse;
	
		
	public Customer() {	}
	
	public Customer(String customerPreName, String customerLastName) {
		this.customerPreName = customerPreName;
		this.customerLastName = customerLastName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAddress(Adresse addresse) {
		this.adresse = adresse;
	}

	public long getCustomerId() {
		return id;
	}	

	public String getCustomerPreName() {
		return customerPreName;
	}

	public void setCustomerPreName(String customerPreName) {
		this.customerPreName = customerPreName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}
	
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}
	
	public List<Account> getAccount() {
		return accounts;
	}
	
	public void setAccount(List<Account> accounts) {
		this.accounts = accounts;
	}
	
}
