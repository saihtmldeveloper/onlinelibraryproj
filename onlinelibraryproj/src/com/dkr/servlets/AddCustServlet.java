package com.dkr.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dkr.service.CustService;
import com.dkr.service.CustServiceFactory;

@WebServlet(description = "servlet for adding new customer", urlPatterns = { "/addcust" })
public class AddCustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		String cname = request.getParameter("cname");
		String mob = request.getParameter("mobno");
		long mobno = Long.parseLong(mob);
		
		CustService custService = CustServiceFactory.getCustService();
		String status = custService.addCust(cid, cname, mobno);

		RequestDispatcher reqDispatcher = null;
		if(status.equalsIgnoreCase("success")) {
			request.setAttribute("status", 2);
		reqDispatcher = request.getRequestDispatcher("./newcust");
		reqDispatcher.forward(request, response);
		}
		if(status.equalsIgnoreCase("failure")) {
			request.setAttribute("status", 1);
		reqDispatcher = request.getRequestDispatcher("./newcust");
		reqDispatcher.forward(request, response);
		}
		if(status.equalsIgnoreCase("existed")) {
			request.setAttribute("status", 0);
		reqDispatcher = request.getRequestDispatcher("./newcust");
		reqDispatcher.forward(request, response);
		}
	}

}
