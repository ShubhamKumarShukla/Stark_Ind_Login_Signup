package com.starkind.loginsignup.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.starkind.loginsignup.dao.LoginDAO;

//import com.logan.loginapp.dao.UserDAO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

/*	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}*/


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String id = (String) request.getParameter("user");
		String pwd = (String) request.getParameter("pass");
		
		RequestDispatcher dispatcher;
		
//		if(id.equals("tony") && pwd.equals("tony@123"))
		LoginDAO userDAO = new LoginDAO();
		boolean status = userDAO.validate(id, pwd);
		
		if(status)
		{
			dispatcher = request.getRequestDispatcher("HOME.html");
			dispatcher.forward(request, response);
		}
		else
		{
			dispatcher = request.getRequestDispatcher("IndexLogin.html");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html><html><head><meta http-equiv=\"Refresh\" content=\"1;url=IndexLogin.html\"></head><body onload=\"alert('Wrong Username or Password')\"></body></html>");	
		}
	}

}
