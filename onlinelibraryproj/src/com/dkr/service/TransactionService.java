package com.dkr.service;

public interface TransactionService {
	String issueBook(String[] bid,String cid);
	
	String getBook(String[] bid,String cid) ;
}
