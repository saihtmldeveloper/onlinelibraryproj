package com.dkr.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dkr.service.BookService;
import com.dkr.service.BookServiceFactory;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet(description = "for adding new books list to the library", urlPatterns = {"/addbook"})
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bid = request.getParameter("bid");
		String bname = request.getParameter("bname");
		String author = request.getParameter("author");
		String bookCost = request.getParameter("cost");
		
		double cost = Double.parseDouble(bookCost);
		BookService bookService = BookServiceFactory.getBookService();
		String status = bookService.addBook(bid, bname, author, cost);
		RequestDispatcher rd = request.getRequestDispatcher("./books");
		if(status.equalsIgnoreCase("success")) {
			request.setAttribute("status", 1);
			rd.forward(request, response);
		}
		if(status.equalsIgnoreCase("failure")) {
			request.setAttribute("status", 0);
			rd.forward(request, response);
		}
		
		if(status.equalsIgnoreCase("existed")) {
			request.setAttribute("status", 2);
			rd.forward(request, response);
		}
				
	}

}
