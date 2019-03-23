package com.dkr.dao;

public interface TransactionDao {
	String issueBook(String[] bid, String cid);

	String getBook(String[] bid, String cid);
}
