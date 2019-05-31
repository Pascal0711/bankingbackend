package com.itf.schulung.BankingApp.factory;

public class BalanceFactory {
	
    public static double getCurrentBalance() {
        Double min = -10000.00; 
        Double max = 50000.00; 
        double x = (Math.random() * ((max - min) + 1)) + min; 
        double currentBalance = Math.round(x * 100.0) / 100.0; 
        return currentBalance; 
   }
    
}

