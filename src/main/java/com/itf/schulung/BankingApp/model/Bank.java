package com.itf.schulung.BankingApp.model;

public class Bank {
	
	private String bankName = "PA-BA Online-Banking";
	private String bic = "BIC: HELARADE047";
	private String countryCodeCheckDigit = "DE 20";
	private String blz = "50033496";
	
	
	
	public Bank(String bic) {
		this.bic = bic;
	}
	
	public String getBic() {
		return this.bic;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getCountryCodeCheckDigit() {
		return countryCodeCheckDigit;
	}

	public void setCountryCodeCheckDigit(String countryCode) {
		this.countryCodeCheckDigit = countryCode;
	}

	public String getBlz() {
		return blz;
	}

	public void setBlz(String blz) {
		this.blz = blz;
	}

}
