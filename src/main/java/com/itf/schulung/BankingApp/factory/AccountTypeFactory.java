package com.itf.schulung.BankingApp.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AccountTypeFactory {
	
	static Random random = new Random();
	
	public static String getAccountTypes() {
		List<String> accountTypes = new ArrayList<String>();
			accountTypes.add("saving account");
			accountTypes.add("checking account");
			accountTypes.add("credit card account");
			accountTypes.add("deposit account");
			
			String accountType = accountTypes.get(random.nextInt(accountTypes.size()));
			return accountType;
	}
}
