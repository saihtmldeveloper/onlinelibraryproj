package com.dkr.service;

public class TransactionServiceFactory {
	private static TransactionService transactionService;
	
	static {
		transactionService = new TransactionServiceImpl();
	}
	
	public static TransactionService getTransactionService() {
		return transactionService;
	}
}
