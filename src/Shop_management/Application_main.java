package Shop_management;

import java.io.IOException;
import java.util.Scanner;

import ProductManagement.Productmanagement;
import UserManagement.usermanagement;

public class Application_main {
	
	public static void main(String[] args)throws IOException
	{
		Scanner sc= new Scanner(System.in);
		boolean CanIKeepRunningTheProgram = true;
		
		while(CanIKeepRunningTheProgram == true)
		{
			System.out.println("SHOP-MANAGEMENT SYSTEM");
			System.out.println("\n");

		    System.out.print("Enter your username: ");
		    String username = sc.nextLine();

		    System.out.print("Enter your password: ");
		    String password = sc.nextLine();

		     if(!usermanagement.ValidDataAndPassword(username, password))
		    {
		        System.out.println("Login failed. Please check your username and password.");
		    }
		    
		    System.out.println("WEL-COME TO SHOP-MANAGEMENT SYSTEM");
			System.out.println("\n");
			System.out.println("1.USERMANAGEMENT");
			System.out.println("2.SHOPMANAGEMENT");
			System.out.println("3.Quite");
			
			int OptionSelectedByUser = sc.nextInt();
			if(OptionSelectedByUser==1)
			{
				usermanagement.userManagement(args);
			}
			else if(OptionSelectedByUser==2)
			{
				Productmanagement.productManagement(args);
			}
			else if(OptionSelectedByUser==3)
			{
				System.out.println("program closed");
			}
		}
	}
}

