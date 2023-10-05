package UserManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class usermanagement {
    static ArrayList<user> al = new ArrayList();
    static
    {
    	try
    	{
    		loadDataFromFileToArrayList();
    	}
    	catch(IOException e)
    	{
    		e.printStackTrace();
    	}
    }
	
	public static void userManagement(String[] args)throws IOException
	{
		
		Scanner sc = new Scanner(System.in);
		boolean CanIKeepRunningTheProgram = true;
		
		while(CanIKeepRunningTheProgram == true)
		{
			System.out.println("WEL-COME TO UERMANAGEMENT SYSTEM");
			System.out.println("1.Add user");
			System.out.println("2.Edit user");
			System.out.println("3.Search user");
			System.out.println("4.Delete user");
			System.out.println("5.Quite");
			
			int OptionSelectedByUser = sc.nextInt();
			
			if(OptionSelectedByUser == UserOption.Quite)
			{
				File file = new File("C:\\Users\\Jai\\eclipse-workspace\\SHOP_MANAGEMENT_18_SEPTEMBER\\src\\UserManagement\\user.txt");
				FileWriter fr = new FileWriter(file,true);
				BufferedWriter br = new BufferedWriter(fr);
				
				String line="";
				for(user u:al)
				{
					br.write(u.username+" , "+u.loginname+" , "+u.password+" , "+u.conformpassword+" , "+u.userrole+"\n");
				}
			    
			    br.close();
			    fr.close();
			    file=null;
				System.out.println("Program closed!!!");
				CanIKeepRunningTheProgram = false;
			}
			else if(OptionSelectedByUser == UserOption.Add_user )
			{
				AddUser();
				System.out.println("\n");
			}
			else if(OptionSelectedByUser == UserOption.Search_user)
			{
				System.out.println("Enter the user name:");
				sc.nextLine();
				String SName = sc.nextLine();
				SearchUser(SName);
				System.out.println("\n");
			}
			else if(OptionSelectedByUser == UserOption.Delete_user)
			{
				System.out.println("Enter the user name:");
				sc.nextLine();
				String DName = sc.nextLine();
				DeleteUser(DName);
				System.out.println("\n");
			}
			else if(OptionSelectedByUser == UserOption.Edit_user)
			{
				System.out.println("Enter the user name:");
				sc.nextLine();
				String EName = sc.nextLine();
				Edituser(EName);
				System.out.println("\n");
			}
		}
		
		for(user U :al)
		{
			System.out.println(U.username);
			System.out.println(U.loginname);
			System.out.println(U.password);
			System.out.println(U.conformpassword);
			System.out.println(U.userrole);
			
		}
		
	}
	public static void AddUser()
	{
        Scanner sc = new Scanner(System.in);
		
		user userobject= new user();
		
		System.out.println("User Name:");
		userobject.username = sc.nextLine();
		
		
		System.out.println("Login Name:");
		userobject.loginname = sc.nextLine();
		
		
		System.out.println("Password:");
		userobject.password = sc.nextLine();
		
		System.out.println("Conform Password:");
		userobject.conformpassword = sc.nextLine();
		
		
		System.out.println("User Role:");
		userobject.userrole = sc.nextLine();
		
		
		System.out.println("User Name:" +userobject.username);
		System.out.println("Login Name:" +userobject.loginname);
		System.out.println("Password:" +userobject.password);
		System.out.println("Conform Password:" +userobject.conformpassword);
		System.out.println("User Role:" +userobject.userrole);
		
		al.add(userobject);
	}
	
	
	public static void SearchUser(String username)
	{
		for(user u: al)
		{
			if(u.username.equalsIgnoreCase(username))
			{
				System.out.println("User Name:" +u.username);
				System.out.println("Login Name:" +u.loginname);
				System.out.println("Password:" +u.password);
				System.out.println("Conform Password:" +u.conformpassword);
				System.out.println("User Role:" +u.userrole);
				return;
			}
			}
		System.out.println("user not found!!!!");
		}
	
	public static void DeleteUser(String username)
	{
		Iterator<user> userIterator = al.iterator();
		
		while(userIterator.hasNext())
		{
			user u = userIterator.next();
			if(u.username.equalsIgnoreCase(username))
			{
				userIterator.remove();
				System.out.println("user " +u.username + " has been deletd");
				break;
			}
		}
	}
	public static void Edituser(String username)
	{
		for(user u : al)
		{
			if(u.username.equalsIgnoreCase(username))
			{
				Scanner sc = new Scanner(System.in);

				System.out.println("User Name:");
				u.username = sc.nextLine();
				
				
				System.out.println("Login Name:");
				u.loginname = sc.nextLine();
				
				
				System.out.println("Password:");
				u.password = sc.nextLine();
				
				System.out.println("Conform Password:");
				u.conformpassword = sc.nextLine();
				
				
				System.out.println("User Role:");
				u.userrole = sc.nextLine();
				
				return;
			}
		}
		System.out.println("user not found!!!");
	}
	public static void loadDataFromFileToArrayList() throws IOException
	{
		File file =new File("C:\\Users\\Jai\\eclipse-workspace\\SHOP_MANAGEMENT_18_SEPTEMBER\\src\\UserManagement\\user.txt");
		
		FileReader fr=new FileReader(file);
		
		BufferedReader br=new BufferedReader(fr);
		
		String line="";
		while((line=br.readLine())!=null)
		{
			user u = new user();
			String[] userDataArray = line.split(",");

		if(userDataArray.length>4)
		{
			u.username=userDataArray[0];
			u.loginname=userDataArray[1];
			u.password=userDataArray[2];
			u.conformpassword=userDataArray[3];
			u.userrole=userDataArray[4];
			
			al.add(u);
		}
		}
		fr.close();
		br.close();
		file= null;
	
	}	
	
	public static boolean ValidDataAndPassword(String username,String passaword)
	{
        Iterator<user> userIterator = al.iterator();
		
		while(userIterator.hasNext())
		{
			user u = userIterator.next();
			if(u.username.equalsIgnoreCase(username)&& u.password.equalsIgnoreCase(passaword))
			{
				return true;
			}
		}
		return false;
	}

}

