package com.starkind.loginsignup.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.starkind.loginsignup.dao.SignUpDAO;

/**
 * Servlet implementation class SignUpController
 */
@WebServlet("/SignUpController")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
/*	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String uname = (String) request.getParameter("user");
		String pwd = (String) request.getParameter("pass");
		String email = (String) request.getParameter("email");
		String mobile = (String) request.getParameter("mob");
		String address = (String) request.getParameter("addr");
		
		RequestDispatcher dispatcher;
		SignUpDAO signupDAO = new SignUpDAO();
		int i = signupDAO.insertUser(email, uname, pwd, mobile, address);
		if(i==1)
		{
			dispatcher = request.getRequestDispatcher("HOME.html");
			dispatcher.forward(request, response);
		}

	}

}
