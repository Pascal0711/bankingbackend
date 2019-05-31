package com.itf.schulung.BankingApp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
public class Adresse {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String streetName;
	
	@NotNull
	private int streetNumber;
	
	private Integer postalCode;
	
	private String city;
	
	private String country;
	
	@OneToOne(mappedBy = "adresse", cascade = CascadeType.ALL)
	private Customer customer;
	

	Adresse() {}


	Adresse(Long id, String streetName, int StreetNumber, int postalCode, String city, String country, int streetNumber) {
		this.id = id;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.postalCode = postalCode;
		this.city = city;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	
//	public long getAdresseId() {
//		return id;
//	}	

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
