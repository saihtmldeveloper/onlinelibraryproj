package com.dkr.service;

public class BookServiceFactory {
	private static BookService bookService;

	static {
		bookService = new BookServiceImpl();
	}

	public static BookService getBookService() {
		return bookService;
	}
}
