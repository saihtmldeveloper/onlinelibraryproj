package com.dkr.service;

import com.dkr.dao.BookDao;
import com.dkr.dao.BookDaoFactory;

public class BookServiceImpl implements BookService {
	@Override
	public String addBook(String bid, String bname, String author, double cost) {
		BookDao bookDao = BookDaoFactory.getBookDao();
		String status = bookDao.addBook(bid, bname, author, cost);
		return status;
	}
}
