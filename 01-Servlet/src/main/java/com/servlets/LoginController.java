package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginController extends GenericServlet {

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = arg0.getParameter("lEmail");
		String pass = arg0.getParameter("lPass");
		
		UserCrud crud = new UserCrud();
		PrintWriter out = arg1.getWriter();
		try {
			String pass1 = crud.login(email);
			if(pass1!=null) {
				if(pass1.equals(pass)) {
					out.println("Login Successful");
				}
				else {
					out.println("Incorrect PassWord");
				}
			}
			else {
				out.println("User Not Register");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}