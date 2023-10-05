package ProductManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Productmanagement {

	static ArrayList<user> al = new ArrayList();
			
	public static void productManagement(String[] args)throws IOException
			{
				loadDataFromFileToArrayList();
				Scanner sc = new Scanner(System.in);
				boolean CanIKeepRunningTheProgram = true;
				
				while(CanIKeepRunningTheProgram == true)
				{
					System.out.println("WEL-COME TO PRODUCT-MANAGEMENT SYSTEM");
					System.out.println("1.Add product");
					System.out.println("2.Edit product");
					System.out.println("3.Search product");
					System.out.println("4.Delete product");
					System.out.println("5.Quite");
					
					int OptionSelectedByUser = sc.nextInt();
					
					if(OptionSelectedByUser ==UserOption.Quite)
					{
						File file = new File("C:\\Users\\Jai\\eclipse-workspace\\SHOP_MANAGEMENT_18_SEPTEMBER\\src\\ProductManagement\\product.txt");
						FileWriter fr = new FileWriter(file,true);
						BufferedWriter br = new BufferedWriter(fr);
						
						String line="";
						for(user u:al)
							
						{
							br.write(u.Name+","+u.ID+","+u.Category+","+u.Quality+","+u.Price+"\n");
						}
					    
					    br.close();
					    fr.close();
					    file=null;
						System.out.println("Program closed!!!");
						CanIKeepRunningTheProgram = false;
					}
					else if(OptionSelectedByUser == UserOption.Add_product)
					{
						AddProduct();
						System.out.println("\n");
					}
					else if(OptionSelectedByUser == UserOption.Edit_product)
					{
						System.out.println("Enter the product name:");
						sc.nextLine();
						String EName = sc.nextLine();
						Searchproduct(EName);
						System.out.println("\n");
					}
					else if(OptionSelectedByUser == UserOption.Search_product)
					{
						System.out.println("Enter the product name:");
						sc.nextLine();
						String SName = sc.nextLine();
						Deleteproduct(SName);
						System.out.println("\n");
					}
					else if(OptionSelectedByUser == UserOption.delete_product)
					{
						System.out.println("Enter the product name:");
						sc.nextLine();
						String DName = sc.nextLine();
						Editproduct(DName);
						System.out.println("\n");
					}
				}
				
				for(user U :al)
				{
					System.out.println(U.Name);
					System.out.println(U.ID);
					System.out.println(U.Category);
					System.out.println(U.Quality);
					System.out.println(U.Price);				
				}
				
			}
	public static void AddProduct()
			{
		        Scanner sc = new Scanner(System.in);
				
				user u= new user();
				
				System.out.println("Product Name:");
				u.Name = sc.nextLine();
				
				
				System.out.println("ID:");
				u.ID = sc.nextLine();
				
				
				System.out.println("Category:");
				u.Category = sc.nextLine();
				
				System.out.println("Quality:");
				u.Quality= sc.nextLine();
				
				
				System.out.println("Price:");
				u.Price= sc.nextLine();
				
				
				System.out.println("Product name"+u.Name);
				System.out.println("ID:" +u.ID);
				System.out.println("Category:" +u.Category);
				System.out.println("Quality:" +u.Quality);
				System.out.println("Price:" +u.Price);
				
			al.add(u);
			}
			
			
	public static void Searchproduct(String Name)
			{
				for(user u: al)
				{
					if(u.Name.equalsIgnoreCase(Name))
					{
						System.out.println("Product name"+u.Name);
						System.out.println("ID:" +u.ID);
						System.out.println("Category:" +u.Category);
						System.out.println("Quality:" +u.Quality);
						System.out.println("Price:" +u.Price);
						return;
					}
				}
				System.out.println("user not found!!!!");
			}
		
	public static void Deleteproduct(String Name)
			{
				Iterator<user> userIterator = al.iterator();
				
				while(userIterator.hasNext())
				{
					user u = userIterator.next();
					if(u.Name.equalsIgnoreCase(Name))
					{
						userIterator.remove();
						System.out.println("user " +u.Name + " has been deletd");
						break;
					}
				}
			}
		
	public static void Editproduct(String Name)
			{
				for(user u : al)
				{
					if(u.Name.equalsIgnoreCase(Name))
					{
						Scanner sc = new Scanner(System.in);

						System.out.println("User Name:");
						u.Name = sc.nextLine();
						
						
						System.out.println("Login Name:");
						u.ID = sc.nextLine();
						
						
						System.out.println("Password:");
						u.Category= sc.nextLine();
						
						System.out.println("Conform Password:");
						u.Quality = sc.nextLine();
						
						
						System.out.println("User Role:");
						u.Price= sc.nextLine();
						
						return;
					}
				}
				System.out.println("product not found!!!");
			}
		
	public static void loadDataFromFileToArrayList() throws IOException
			{
				File file =new File("C:\\Users\\Jai\\eclipse-workspace\\SHOP_MANAGEMENT_18_SEPTEMBER\\src\\ProductManagement\\product.txt");
				
				FileReader fr=new FileReader(file);
				
				BufferedReader br=new BufferedReader(fr);
				
				String line="";
				while((line=br.readLine())!=null)
				{
					user u = new user();
					String[] userDataArray = line.split(",");

				if(userDataArray.length>4)
				{
					u.Name=userDataArray[0];
					u.ID=userDataArray[1];
					u.Category=userDataArray[2];
					u.Quality=userDataArray[3];
					u.Price=userDataArray[4];
					
					al.add(u);
				}
				}
				fr.close();
				br.close();
				file= null;
			
			}	
}
