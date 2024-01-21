package com.question2;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		Operations operations = new Operations("jdbc:mysql://localhost:3306/gl", "root", "04262330");

		int choice = 0;
		Scanner sc = new Scanner(System.in);

		while(choice != 7)
		{
			System.out.println("Enter 1 to add Employees");
			System.out.println("Enter 2 to view all employee ");
			System.out.println("Enter 3 to modify email column ");
			System.out.println("Enter 4 to update name and mobile of employee");
			System.out.println("Enter 5 to delete specific employee");
			System.out.println("Enter 6 to delete all employee");
			System.out.println("Enter 7 to exit");
			System.out.print("Enter your choice from above: ");
			choice = sc.nextInt();
			switch(choice)
			{
			case 1: 
			{
				operations.addEmployee();
				break;
			}
			case 2 :
			{
				operations.displayAll();
				break;
			}
			case 3 :
			{
				operations.modifyEmailColumn(operations.statement);
				break;
			}
			case 4 :
			{
				operations.updateNameMobile();
				break;
			}
			case 5 :
			{
				operations.deleteSpecific();
				break;
			}
			case 6 :
			{
				operations.deleteAll();
				break;
			}
			case 7 :
			{
				break;
			}
			default :
			{
				System.err.println("Invalid choice. Try again..");
			}
			}
		}
		sc.close();

	}

}
