package com.servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserCrud {
	
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{

		String className = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/customerdb";
		String username = "root";
		String password = "root";
		
		Class.forName(className);	
	
		Connection conn = DriverManager.getConnection(url,username,password);
	
		return conn;
		
	}
	
	public int signUp(User usr) throws Throwable
	{
	
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement("Insert into user values(?,?,?,?,?,?,?)");
		pstmt.setInt(1, usr.getId());
		pstmt.setString(2, usr.getName());
		pstmt.setString(3, usr.getfName());
		pstmt.setString(4, usr.getmName());
		pstmt.setInt(5, usr.getAge());
		pstmt.setString(6, usr.getEmail());
		pstmt.setString(7, usr.getPassword());
		
		int result = pstmt.executeUpdate();
	
		return result;
	}
	
	public String login(String lEmail) throws ClassNotFoundException, SQLException
	{
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select password from user where email='"+lEmail+"'");
		ResultSet rs = pstmt.executeQuery();
		String pass1 =null;
		if(rs.next())
		{
	
			 pass1=rs.getString("password");
		}
		return pass1;
		
	}

}
