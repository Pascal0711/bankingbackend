package com.itf.schulung.BankingApp.factory;
import java.util.concurrent.ThreadLocalRandom;

public class AccountIdFactory {
  	
	public static int getAccountId() {
	int accountId = ThreadLocalRandom.current().nextInt(1, 10000 + 1);
	return accountId;
	}
}



