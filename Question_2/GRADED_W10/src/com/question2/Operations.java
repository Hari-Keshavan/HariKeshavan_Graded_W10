package com.question2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Operations {

	private Connection connection ;
	Statement statement;
	private ResultSet rs;
	Scanner sc = new Scanner(System.in);

	public Operations(String url,String uname,String pw)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url,uname,pw);
			statement = connection.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Connected successfully");
		System.out.println();
	}

	public void disconnect()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void addEmployee()
	{
		System.out.print("Enter number of records you want to insert: ");
		int count = sc.nextInt();
		for(int i=0 ; i<count ; i++)
		{
			System.out.println("Enter id, name, email, mobile number of employee ("+(i+1)+") separated by space: ");
			String insertQuery = "insert into employee values ( "+sc.nextInt()+",'"+sc.next()+"', '"+sc.next()+"', '"+sc.next()+"')";
			try {
				statement.execute(insertQuery);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println();
	}
	
	public void modifyEmailColumn(Statement statement) {
		try {
			 String modifyQuery = "ALTER TABLE employee MODIFY COLUMN email_id VARCHAR(30) NOT NULL";
			 statement.executeUpdate(modifyQuery);
		     System.out.println("Email_Id column modified successfully.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
	  }
	
	public void updateNameMobile()
	{
		System.out.print("Enter id where update: ");
		int id = sc.nextInt();
		System.out.print("Enter name to update: ");
		String name = sc.next();
		System.out.print("Enter mobile number to update: ");
		String mobile = sc.next();
		String query = "update employee set name = '"+name+"' , phone_number = '"+mobile+"' where id = "+id+" ";
		System.out.println(query);
		try {
			statement.execute(query);
			System.out.println("Column altered successfully...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
	}
	
	public void deleteAll()
	{
		String query = "truncate table employee";
		try {
			statement.execute(query);
			System.out.println("All Employees are deleted");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
	}
	
	public void deleteSpecific()
	{
		System.out.print("Enter the number of id's to delete: ");
		int countId = sc.nextInt();
		System.out.println("Enter "+countId+" id's to delete: ");
		for(int i = 0 ; i < countId ; i++)
		{
			String query = "delete from employee where id = "+sc.nextInt();
			try {
				statement.execute(query);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println();
	}
	
	public void displayAll()
	{
		String query = "Select * from employee";
		try {
			rs = statement.executeQuery(query);
			if(rs.isBeforeFirst())
			{
				while(rs.next())
				{
					System.out.printf("%-5d%-20s%-25s%s",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
					System.out.println();
				}
			}
			else
			{
				System.out.println("No records found");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
	}
}
