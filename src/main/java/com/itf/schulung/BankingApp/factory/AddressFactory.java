package com.itf.schulung.BankingApp.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class AddressFactory {
	
	public static String getStreetName() {
		List<String> silben = new ArrayList<String>(); // diese Liste wird mit [ba, be, bi, bo, bu, ca, ce,...] befuellt

		for (char c = 'a'; c <= 'z'; c++) {
			if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c!= 'q' && c!='z' && c!= 'x') {
				silben.add(c + "a");
				silben.add(c + "e");
				silben.add(c + "i");
				silben.add(c + "o");
				silben.add(c + "u");
			} else if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				silben.add(c+"");
			}
		}
		
		String streetName = (silben.get(ThreadLocalRandom.current().nextInt(0, silben.size()))).substring(0, 1).toUpperCase()
				+ (silben.get(ThreadLocalRandom.current().nextInt(0, silben.size()))).substring(1);
					
		int random = ThreadLocalRandom.current().nextInt(1, 4);
		for(int i = 0; i<random; i++) {
			streetName += silben.get(ThreadLocalRandom.current().nextInt(0, silben.size()));
		}
					
	return streetName + " Str. ";	

	}

	public static int getStreetNumber() {
		Random rand = new Random(); 
		int streetNumber = rand.nextInt(120); 
	   
			return streetNumber;
		}
		
	    public static int getPostalCode() {
	    	  Random rand = new Random();
	    	  int postalCode = rand.nextInt((99999 - 10000) + 1) + 10000;
	    	  return postalCode;
	    }
    
	    public static String getCityName() {
			List<String> silben = new ArrayList<String>(); // diese Liste wird mit [ba, be, bi, bo, bu, ca, ce,...] befuellt

			for (char c = 'a'; c <= 'z'; c++) {
				if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c!= 'q' && c!='z' && c!= 'x') {
					silben.add(c + "a");
					silben.add(c + "e");
					silben.add(c + "i");
					silben.add(c + "o");
					silben.add(c + "u");
				} else if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
					silben.add(c+"");
				}
			}
			
			String cityName = (silben.get(ThreadLocalRandom.current().nextInt(0, silben.size()))).substring(0, 1).toUpperCase()
					+ (silben.get(ThreadLocalRandom.current().nextInt(0, silben.size()))).substring(1);
						
			int random = ThreadLocalRandom.current().nextInt(1, 4);
			for(int i = 0; i<random; i++) {
				cityName += silben.get(ThreadLocalRandom.current().nextInt(0, silben.size()));
			}
						
		return cityName;	

		}
	   
}
