package com.dkr.dao;

public class BookDaoFactory {
	private static BookDao bookDao;

	static {
		bookDao = new BookDaoImpl();
	}

	public static BookDao getBookDao() {
		return bookDao;
	}
}
