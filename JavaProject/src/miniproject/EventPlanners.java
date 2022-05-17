package miniproject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class EventPlanners {

	public static void main(String[] args) throws FileNotFoundException, SQLException, IOException, ParseException{
		// We will do add,update,delete and search operations using PreparedStatement
		
		int choice;
		char ch;
		CustomerDetails c = new CustomerDetails();
		do {
		System.out.println("\nSelect an option \n1 for booking event \n2 for update your details if you want \n3 for Search Customer Details with particular value \n4  for delete any particular details \n5 for view all details \n6 for Exit");
		Scanner scan = new Scanner(System.in);
		choice=scan.nextInt();
			switch(choice)
			{
			case 1:
				c.getCutomerDetails();
				c.insertCustomerDetails();
				break;
			case 2:
				c.updateCustomerDetails();
				break;
			case 3:
				c.searchCustomerDetails();
				break;
			case 4:
				c.deleteCustomerDetails();
				break;
			case 5:
				c.readCustomerDetails();
				break;
			case 6:
				System.out.println("...Thanks For Visiting Our Page...");
				System.exit(0);
				break;
			default:
				System.out.println("Please Select The Correct Option From The Above");
			}
			
			System.out.println("\nDo you want to continue(y/n): ");
	    	ch=scan.next().charAt(0);
		}
		 while(ch=='y'|| ch=='Y');
		
	}
	
	
}
