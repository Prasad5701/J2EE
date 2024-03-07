package com.library;

import java.util.* ;
import java.sql.*;
public class Library {

	

	public static void main(String[] args) throws SQLException ,ClassCastException, ClassNotFoundException{
		
		System.out.println("Welcome to Library");
		
		System.out.print("Press Key : ");
		System.out.print(" 1 for signUp ");
		System.out.print(" 2 for LogIn ");
		System.out.print(" 3 For Exit ");
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		switch(num)
		{
		case 1:
			
			System.out.println("Welcome to SignUn Page");
			System.out.println();
			System.out.println("Please Enter Your Details");
			System.out.println();

			System.out.print("Id : ");
			int name = sc.nextInt();
			System.out.print("Username : ");
			String email = sc.next();
			System.out.print("Phone : ");
			long phone = sc.nextLong();
			System.out.print("Password : ");
			String pass = sc.next();
			System.out.print("Location : ");
			String loc = sc.next();
			
			String className ="com.mysql.cj.jdbc.Driver";
			String url ="jdbc:mysql://localhost:3306/librarydb";
			String user = "root";
			String password = "root";
			
			
			try {
				Class.forName(className);
			} catch (Exception e) {
				System.out.println("Class Not Found");
			}
			Connection conn = DriverManager.getConnection(url,user,password);
			
			String query = "insert into userinfo values(?,?,?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, name);
			pstmt.setString(2, email);
			pstmt.setLong(3, phone);
			pstmt.setString(4, pass);
			pstmt.setString(5, loc);
			
			int result = pstmt.executeUpdate();
			if(result!=0)
			{
				System.out.println("Sign Up Successful");
			}
			else 
			{
				System.out.println("Enter All Crediential");
			}
			
			conn.close();
			
			
		case 2:
			System.out.println("Welcome to LogIn Page");
			
			System.out.println(" Please LogIn ");
			
			System.out.print("Username : ");
			String lEmail = sc.next();
			System.out.print("Password : ");
			String lPass = sc.next();
			

			String className1 ="com.mysql.cj.jdbc.Driver";
			String url1 ="jdbc:mysql://localhost:3306/librarydb";
			String user1 = "root";
			String password1 = "root";
			Class.forName(className1);
			
			Connection conn1 = DriverManager.getConnection(url1,user1,password1);
			
			String query1 = "select * from userinfo";
			
			PreparedStatement pstmt1 = conn1.prepareStatement(query1);
		
		
			
			ResultSet rs = pstmt1.executeQuery();
			
			
			while(rs.next()){
				
				String eStr=rs.getString(2);
				String pStr=rs.getString(4);
				
				if(lEmail.contains(eStr))
				{
					if(lPass.contains(pStr))
					{
						System.out.println("Login Successful");
						System.out.println();
						
						System.out.println("1 Get All Books");
						System.out.println("2 Add Book");
						System.out.println("3 Delete Book");
						System.out.println("4 Update Book Details");
						System.out.println("5 Get Book By Id");
						System.out.println("6 Get Book By Name");
						System.out.println("7 Get Book By Author");
						System.out.println("8 get Book By Genres");
						System.out.println("9 Logout");
						
						System.out.println();
						System.out.print("Enter Your Choice : ");
						int num1 = sc.nextInt();
						switch(num1)
						{
						case 1:
							
							String query3= "select * from library";
							PreparedStatement pstmt3 = conn1.prepareStatement(query3);
							
							ResultSet rs3 = pstmt3.executeQuery();
							
							while(rs3.next())
							{
								System.out.print(rs3.getInt(1)+"  ");
								System.out.print(rs3.getString(2)+"  ");
								System.out.print(rs3.getString(3)+"  ");
								System.out.print(rs3.getString(4)+"  ");
								System.out.print(rs3.getInt(5)+"  ");
								System.out.println();
							}
							pstmt3.execute();
							pstmt3.close();
							
							break;
						case 2:
							
							System.out.print("Enter Book Id : ");
							int id = sc.nextInt();
							System.out.print("Enter Book Name : ");
							String lname = sc.next();
							System.out.print("Enter Author of Book : ");
							String author = sc.next();
							System.out.print("Enter Genres of Book : ");
							String genres = sc.next();
							System.out.println("Enter Price of Book  : ");
							int price = sc.nextInt();
							
							String query4= "insert into library values(?,?,?,?,?)";
							
							PreparedStatement pstmt4 = conn1.prepareStatement(query4);
							
							pstmt4.setInt(1, id);
							pstmt4.setString(2, lname);
							pstmt4.setString(3, author);
							pstmt4.setString(4, genres);
							pstmt4.setInt(5, price);
							
							int result4 = pstmt4.executeUpdate();
							if(result4!=0)
							{
								System.out.println("Book Added Succesfully");
							}
							else 
							{
								System.out.println("Enter All Crediential");
							}	
							pstmt4.close();
							
							break;
						case 3:
							System.out.print("Enter Id Which You want to Delete: ");
							int num5 = sc.nextInt();
							
							String query5 = "delete from library where id='"+num5+"'";	
							PreparedStatement pstmt5 = conn1.prepareStatement(query5);
														
							int result5 = pstmt5.executeUpdate();
							
							if(result5==1)
							{
								System.out.println("Book Id "+num5+" Deleted Successfully");
							}		
								
							pstmt5.close();
							break;
							
						case 4:

							System.out.println();
							System.out.print("Enter Id You want to Update : ");
							int num7 = sc.nextInt();
							
							
							System.out.println();
							System.out.println("Enter 1 to update id ");
							System.out.println("Enter 2 to update name ");
							System.out.println("Enter 3 to update author ");
							System.out.println("Enter 4 to update genres ");
							System.out.println("Enter 5 to update price ");
							System.out.println();
							
							System.out.print("What you want to Update in "+ num7 +" : ");
							int str = sc.nextInt();
							System.out.println();
							
							switch(str)
							{
							case 1:
								
								System.out.print("Enter New Id : ");
								int newId = sc.nextInt();
								String query6 = "update library set id='"+newId+"' where id='"+num7+"'";
								PreparedStatement pstmt6 = conn1.prepareStatement(query6);
						
								 int result6 = pstmt6.executeUpdate();
								 if(result6!=0)
								 {
									 System.out.println("Id Updated");
								 }
								 else
								 {
									 System.out.println("Id Not Updated");
								 }
								 
								
								break;
							case 2:
								System.out.print("Enter New name : ");
								String name1  = sc.next();
								String query7 = "update library set lname='"+name1+"' where id='"+num7+"'";
								PreparedStatement pstmt7 = conn1.prepareStatement(query7);
								
								int result7 = pstmt7.executeUpdate();
								if(result7!=0)
								 {
									 System.out.println("Book Name Updated");
								 }
								 else
								 {
									 System.out.println("Book Name Not Updated");
								 }
								break;
							case 3:
								System.out.print("Enter New author name : ");
								String name2  = sc.next();
								String query8 = "update library set author='"+name2+"' where id='"+num7+"'";
								PreparedStatement pstmt8 = conn1.prepareStatement(query8);
								
								int result8 =pstmt8.executeUpdate();
								if(result8!=0)
								 {
									 System.out.println("Author Name Updated");
								 }
								 else
								 {
									 System.out.println("Author Name Not Updated");
								 }
								break;
							case 4:
								System.out.print("Enter New genres : ");
								String name3  = sc.next();
								String query9 = "update library set genres='"+name3+"' where id='"+num7+"'";
								PreparedStatement pstmt9 = conn1.prepareStatement(query9);
								
								int result9 = pstmt9.executeUpdate();
								if(result9!=0)
								 {
									 System.out.println("Genres Updated");
								 }
								 else
								 {
									 System.out.println("Genres Not Updated");
								 }
								break;
							case 5:
								System.out.print("Enter New price : ");
								int newPrice = sc.nextInt();
								String query10 = "update library set price='"+newPrice+"' where id='"+num7+"'";
								PreparedStatement pstmt10 = conn1.prepareStatement(query10);

								int result10 =pstmt10.executeUpdate();
								if(result10!=0)
								 {
									 System.out.println("Price Updated");
								 }
								 else
								 {
									 System.out.println("Price Not Updated");
								 }
								break;
								
							default:
								System.out.println("Wrong Choice");
								break;
							}
		
							break;
						case 5:
							System.out.print("Enter Book Id : ");
							int id1 = sc.nextInt();
							
							String query11= "Select * from library where id= '"+id1+"' ";
							PreparedStatement pstmt11 = conn1.prepareStatement(query11);
							
							ResultSet rs4 = pstmt11.executeQuery();
							while(rs4.next()) {
							System.out.println(rs4.getInt(1));
							System.out.println(rs4.getString(2));
							System.out.println(rs4.getString(3));
							System.out.println(rs4.getString(4));
							System.out.println(rs4.getInt(5));
							
							}
							pstmt11.execute();
							pstmt11.close();
							break;
						case 6:
							System.out.print("Enter Book Name : ");
							String name1 = sc.next();
							
							String query12= "Select * from library where lname= '"+name1+"' ";
							PreparedStatement pstmt12 = conn1.prepareStatement(query12);
							
							ResultSet rs5 = pstmt12.executeQuery();
							while(rs5.next()) {
							System.out.println(rs5.getInt(1));
							System.out.println(rs5.getString(2));
							System.out.println(rs5.getString(3));
							System.out.println(rs5.getString(4));
							System.out.println(rs5.getInt(5));
							
							}
							pstmt12.execute();
							pstmt12.close();
							break;
						case 7:
							System.out.print("Enter Book Author Name : ");
							String author1 = sc.next();
							
							String query13= "Select * from library where author= '"+author1+"' ";
							PreparedStatement pstmt13 = conn1.prepareStatement(query13);
							
							ResultSet rs6 = pstmt13.executeQuery();
							while(rs6.next()) {
							System.out.println(rs6.getInt(1));
							System.out.println(rs6.getString(2));
							System.out.println(rs6.getString(3));
							System.out.println(rs6.getString(4));
							System.out.println(rs6.getInt(5));
							
							}
							pstmt13.execute();
							pstmt13.close();
							break;
						case 8:
							System.out.print("Enter Book Genres : ");
							String genres1 = sc.next();
							
							String query14= "Select * from library where genres= '"+genres1+"' ";
							PreparedStatement pstmt14 = conn1.prepareStatement(query14);
							
							ResultSet rs7 = pstmt14.executeQuery();
							while(rs7.next()) {
							System.out.println(rs7.getInt(1));
							System.out.println(rs7.getString(2));
							System.out.println(rs7.getString(3));
							System.out.println(rs7.getString(4));
							System.out.println(rs7.getInt(5));
							
							}
							pstmt14.execute();
							pstmt14.close();
							break;
						case 9:
							if(num1==9) {
								System.out.println("Logout Successfully");
							}
							
							break;
						default:
							System.out.println("Wrong Choice");
							break;
						}
						
						
						
						
					}
					else {
						System.out.println("Incorrect Password");
						System.out.println();
						Scanner cs = new Scanner(System.in);
						System.out.println("Press 1 For ReEnter Password");
						System.out.println("Press 2 For Forget Password");
						int num1 = sc.nextInt();
						switch(num1)
						{
						
						case 2:
							System.out.println("Forget Password");
							System.out.println();
							System.out.print("Enter Email to Forget PassWord : ");
							String email1 = cs.next();
							if(email1.contains(eStr))
							{
								Class.forName(className1);
								
								Connection conn2 = DriverManager.getConnection(url1,user1,password1);
								
								String query2 = "SELECT * FROM userinfo where email='"+email1+"'";
								
								Statement stmt = conn2.createStatement();		
								ResultSet set = stmt.executeQuery(query2);
								System.out.print("Enter New Password : ");
								String newPass = cs.next();
								int result2 = stmt.executeUpdate("update userinfo set pass ='"+newPass+"' where email='"+email1+"'");
								//
								
								//
								if(result2!=0)
								{
									System.out.println("Password Update Successfully");
								}
								else 
								{
									System.out.println("Password Updation Failed");
								}
								
								conn2.close();
							}
							else {
								System.out.println("Email Not Found");
							}
							
							break;
						case 1 :
							System.out.print("ReEnter Password : ");
							lPass = cs.next();
							if(lPass.contains(pStr))
							{
								System.out.println("Login Successful");
							}
							else
							{
								System.out.println("Wrong Password");
							}
							break;
						default:
							System.out.println("Entered Wron Choice");
						}//switch end here
						
					
					}//inner else end here
					
				}//Outer main If end here
				
			
				else 
				{
					System.out.println();
					System.out.println("No User Register With This Email");
				}
				
		
			}
			
			//pstmt1.close();
			conn1.close();
				
			break;
			
		case 3:
			System.out.println("Thank You For Visiting");
			break;
			
		default:
		{
			System.out.println("Entered Wrong Choice");
			break;
		}
		
		}
		
		
 
	}

}

