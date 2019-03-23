package com.dkr.service;

import com.dkr.dao.TransactionDao;
import com.dkr.dao.TransactionDaoFactory;

public class TransactionServiceImpl implements TransactionService {
	static TransactionDao t = TransactionDaoFactory.getTransactionDao();

	@Override
	public String issueBook(String[] bid, String cid) {
		String status = t.issueBook(bid, cid);
		
		return status;
	}

	@Override
	public String getBook(String[] bid, String cid) {
		
		String status = t.issueBook(bid, cid);
		
		return status;
	}
 
}
