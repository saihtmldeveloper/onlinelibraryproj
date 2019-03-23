package com.dkr.dao;

public class TransactionDaoFactory {
	private static TransactionDao transactionDao;
	
	static {
		transactionDao = new TransactionDaoImpl();
	}
	
	public static TransactionDao getTransactionDao() {
		return transactionDao;
	}
}
