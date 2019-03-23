package com.dkr.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dkr.service.TransactionService;
import com.dkr.service.TransactionServiceFactory;

@WebServlet("/issueserv")
public class IssueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] bid = request.getParameterValues("bid");
		String cid = request.getParameter("cid");
		
		TransactionService t = TransactionServiceFactory.getTransactionService();
		String status = t.issueBook(bid, cid);
		RequestDispatcher rd = request.getRequestDispatcher("./issuepage");
		if(status.equalsIgnoreCase("success")) {
			request.setAttribute("status", 1);
			rd.forward(request, response);
		}
		
		if(status.equalsIgnoreCase("failure")) {
			request.setAttribute("status", 0);
			rd.forward(request, response);
		}
		
		if(status.equalsIgnoreCase("max")) {
			request.setAttribute("status", 2);
			rd.forward(request, response);
		}
		
	}

}
