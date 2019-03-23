package com.dkr.service;

public class CustServiceFactory {
	private static CustService custService;
	
	static {
		custService = new CustServiceImpl();
	}
	
	public static CustService getCustService() {
		return custService;
	}
}
