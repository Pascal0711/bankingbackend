package com.itf.schulung.BankingApp.factory;

import java.util.Random;

public class IbanFactory {
	
	public String countryCode = "DE20";	

		Random rand = new Random();
		
	    public static String getIbanNumber() {
	    	 Random rand = new Random();
	    	 String ibanNumber;
	    	 String countryCode= "DE20";
	    	 String blz= "5003";
	    	 String code= "3496";
	    	 
	    	final String accountNumber= "0123456789"; 
	    	
	    	StringBuilder a= new StringBuilder();
	     final	String Ibn= "" ;
	     a.append(Ibn);
	     a.append(countryCode);
	     a.append(blz);
	     a.append(code);
	     for (int i = 1; i <= accountNumber.length(); i++) {
	     
	    a.append(accountNumber.charAt(rand.nextInt(accountNumber.length())));
	     }  
	    ibanNumber = countryCode + " " + blz + " " + code + a.toString();
	    return ibanNumber;
	}
	  
}
