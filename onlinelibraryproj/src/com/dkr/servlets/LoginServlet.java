package com.dkr.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(description = "this is for checking admin credentials", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		//here i am not going to interact with data base 
		RequestDispatcher rd =null;
		
		if(name.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
			
			rd = request.getRequestDispatcher("./action");
			rd.forward(request, response);
			
			
		}else {
			request.setAttribute("status", "0");
			rd= request.getRequestDispatcher("adminlogin.jsp");
			rd.forward(request, response);
			
		}
			
	}

}
