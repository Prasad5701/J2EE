

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		String className = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/employeedb";
		String username = "root";
		String password = "root";
		
		
		
			//1. Load and Register The Driver
			Class.forName(className);	
			
			
			//2 Establish Connection
			Connection conn = DriverManager.getConnection(url,username,password);
			//System.out.println("Connection Establish");
			
			//3 Create Statement
			String query = "select * from emp";
			
			Statement stmt = conn.createStatement();		
			ResultSet set = stmt.executeQuery(query);
	
			//4 Execute Statement
		//int result = stmt.executeUpdate("insert into emp values(17,'nagesh',2000,'yeola',123432424),(19,'yash',3000,'kopergaon',435443424)");
//		if(result!=0)
//		{
//			System.out.println("Values Inserted");
//		}
//		else 
//		{
//			System.out.println("Values Not Inserted");
			
//		}
			
			while(set.next())
			{
				System.out.print(set.getInt(1)+ " ");
				System.out.print(set.getString(2)+ " ");
				System.out.print(set.getInt(3)+ " ");
				System.out.print(set.getString(4)+ " ");
				System.out.print(set.getInt(5)+ " ");
				System.out.println();
			}
			
		
		
			
		//5. close Connection	
	conn.close();
			
			
			
		
		
//		
//			
//			String className = "com.mysql.cj.jdbc.Driver";
//			String url = "jdbc:mysql://localhost:3306/studentdb";
//			String username = "root";
//			String password = "root";
//			
//			
//			
//				
//				Class.forName(className);	
//				
//			
//				Connection conn = DriverManager.getConnection(url,username,password);
//				System.out.println("Connection Establish");
//				
//				
//				//String query = "select * from student";
//				
//				Statement stmt = conn.createStatement();	
//				//ResultSet set = stmt.executeQuery(query);
//				
//
//				int result = stmt.executeUpdate("insert into student values(192,'prasad',60000),(193,'aditya',70000)");  
//				
//				conn.close();
//			
				
				
		
		
		
		

	}

}

