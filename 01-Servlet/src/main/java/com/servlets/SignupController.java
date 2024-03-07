package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Reg")
public class SignupController extends GenericServlet{

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(arg0.getParameter("id"));
		String name = arg0.getParameter("name");
		String fName = arg0.getParameter("fName");
		String mName = arg0.getParameter("mName");
		int age = Integer.parseInt(arg0.getParameter("age"));
		String email = arg0.getParameter("email");
		String password = arg0.getParameter("pass");
		
		
		User usr= new User();
		usr.setId(id);
		usr.setName(name);
		usr.setfName(fName);
		usr.setmName(mName);
		usr.setAge(age);
		usr.setEmail(email);
		usr.setPassword(password);
		
		UserCrud crud = new UserCrud();
		
		PrintWriter out = arg1.getWriter();
		int count;
		try {
			count = crud.signUp(usr);
			if(count!=0)
			{
				out.println("Sign Up Successful");
			}
			else
			{
				out.println("Sign Up Failed");
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		
		
	}
		
	
}