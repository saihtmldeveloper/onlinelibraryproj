package com.dkr.dao;

public class CustDaoFactory {
	private static CustDao custDao;
	
	static {
		custDao = new CustDaoImpl();
	}
	
	public static CustDao getCustDao() {
		return custDao;
	}
}
