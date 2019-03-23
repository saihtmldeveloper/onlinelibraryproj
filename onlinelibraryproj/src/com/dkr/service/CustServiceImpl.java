package com.dkr.service;

import com.dkr.dao.CustDao;
import com.dkr.dao.CustDaoFactory;
import com.dkr.to.Customer;

public class CustServiceImpl implements CustService {

	@Override
	public String addCust(String cid, String cname, long mobno) {
		CustDao custDao = CustDaoFactory.getCustDao();
		String status = custDao.add(cid, cname, mobno);
		return status;
	}

}
