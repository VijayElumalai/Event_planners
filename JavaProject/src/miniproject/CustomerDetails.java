package miniproject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerDetails {
	private int s_No=0;
	private String cust_Name;
	private String event_Type;
	private String venue_Name;
	private String gift_Name;
	private double total_Amount;
	private String event_Date;
	private String location;
	private String city;
	private String phone_No;
	private String mailId;
	
	Connection con;
	Statement st;
	PreparedStatement ps;
	ResultSet rs;
	
	public  CustomerDetails() throws SQLException, FileNotFoundException, IOException
	{
		
		con = MyConnection.getMyConnection();
		System.out.println("....Welcome To Surprise Event Planners....");
		
	}
	
	public void getCutomerDetails() throws SQLException {
		System.out.println("\nOur Surprise Guru Request You To Happily Fill The Form Below... ");
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter your Name: ");
		cust_Name=sc.nextLine();
		char ch;
		do {
			System.out.println("\nList Of Events....");
			ArrayList<String>arraylist=new ArrayList<String>();
			arraylist.add("Anniversary");
			arraylist.add("BirthdayParty");
			arraylist.add("Wedding");
			arraylist.add("Proposal");
			for (String string : arraylist) {
				System.out.println(string);
			}
			Scanner k = new Scanner(System.in);
			System.out.println("\nEnter the EventType: ");
			event_Type=k.nextLine();
			if(arraylist.contains(event_Type))
			{
				System.out.print("Everyday Is A Reason To Celebrate!!!");
			}
			else
			{
				System.out.println("\nNOT AVAILABLE....PLEASE SELECT FROM THE ABOVE!!!");
			}
			System.out.println("\nDo you want select event type again(y/n): ");
			ch=sc.next().charAt(0);
		}
		while(ch=='y' || ch=='Y');
		
		char choice;
		do {
			System.out.println("\nList Of Venue");
			ArrayList<String> arraylist1=new ArrayList<String>();
			arraylist1.add("Fortune Select Grand");
			arraylist1.add("SMS Elite Party Hall");
			arraylist1.add("Green Grand Inn");
			arraylist1.add("Taj Hotel");
			arraylist1.add("Hotel Chennai Deluxe");
			for (String string : arraylist1) {
				System.out.println(string);
			}
			Scanner scanner = new Scanner(System.in);
			System.out.println("\nEnter the VenueName: ");
			venue_Name=scanner.nextLine();
			if(arraylist1.contains(venue_Name))
			{
				System.out.print("Together Is Our Favorite Place To Be!!!");
			}
			else
			{
				System.out.println("\nNOT AVAILABLE....PLEASE SELECT FROM THE ABOVE!!!");
			}
			System.out.println("\nDo you want select Venue Name again(y/n):");
			choice=sc.next().charAt(0);	
		}
		while(choice=='y' || choice=='Y');
		char select;
		do {
		System.out.println("\nList Of Gifts");
		ArrayList<String> arraylist3=new ArrayList<String>();
		arraylist3.add("Art Forms");
		arraylist3.add("Caricatures");
		arraylist3.add("Hand Crafted");
		arraylist3.add("Romantic Gifts");
		arraylist3.add("Book Loves");
		for (String string : arraylist3) {
			System.out.println(string);
			
		}
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("\nEnter the GiftName: ");
		gift_Name=scanner1.nextLine();
		if(arraylist3.contains(gift_Name))
		{
			System.out.print("The Gifts Come From The HEART Not The Store!!!");
		}
		else
		{
			System.out.println("\nNOT AVAILABLE....PLEASE SELECT FROM THE ABOVE!!!");
		}
		System.out.println("\nDo you want to select Your Gift Again(y/n):");
		select=sc.next().charAt(0);   
		}	
		while(select=='y' || select=='Y');
		if(event_Type.equals("Anniversary"))
		{
			total_Amount=30000;
			System.out.println("\nTotal Amount is "+total_Amount);
		}
		else if(event_Type.equals("BirthdayParty"))
		{
			total_Amount=45000;
			System.out.println("\nTotal Amount is "+total_Amount);
		}
		else if(event_Type.equals("Wedding"))
		{
			total_Amount=65000;
			System.out.println("\nTotal Amount is "+total_Amount);
		}
		else if(event_Type.equals("Proposal"))
		{
			total_Amount=20000;
			System.out.println("\nTotal Amount is "+total_Amount);
		}	
	

		System.out.println("\nEnter the date of event(yyyy-MM-dd): ");
		event_Date = sc.next();
		LocalDate d1=LocalDate.parse(event_Date);
		System.out.println("Enter the Location: ");
		location=sc.next();
		System.out.println("Enter the City: ");
		city=sc.next();
		System.out.println("Enter your Phone Number: ");
		phone_No=sc.next();
		System.out.println("Enter your MailId: ");
		mailId=sc.next();	
	}
	public void insertCustomerDetails() throws SQLException
	{
		ps = con.prepareStatement("insert into event values(?,?,?,?,?,?,?,?,?,?,?)");
		ps.setInt(1,s_No);
		ps.setString(2, cust_Name);
		ps.setString(3, event_Type );
		ps.setString(4, venue_Name);
		ps.setString(5, gift_Name);
		ps.setDouble(6, total_Amount);
		ps.setString(7, event_Date);
		ps.setString(8, location);
		ps.setString(9, city);
		ps.setString(10, phone_No);
		ps.setString(11, mailId);
		
		int  n=ps.executeUpdate();
		System.out.println("\nYour Form is Submitted");
		System.out.println("\n...Our Surprice Is Waiting For Your Loved Once...");		
	}
	public void updateCustomerDetails() throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Correct City:");
		city=sc.nextLine();
		System.out.println("Enter your phone_No: ");
		phone_No=sc.next();
		ps = con.prepareStatement("update event set city = ? where phone_No=?");
		ps.setString(1, city);
		ps.setString(2, phone_No);
		int i=ps.executeUpdate();
		if(i>0)
		{
			System.out.println("Updated Successfully");
		}
		
		else
		{
			System.out.println("No such Record found in the Database");
		}
			 
	}
	public void searchCustomerDetails() throws SQLException
	{
		System.out.println("If you want to search any particular city name details");
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter the City: ");
		city=sc.nextLine();
		ps=con.prepareStatement("select cust_Name,phone_No,total_Amount from event where city=?");
		ps.setString(1, city);
		rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.print(rs.getString(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.println(rs.getDouble(3));
			System.out.println();
		}
	}
	public void deleteCustomerDetails() throws SQLException
	{   
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Phone number if you want to delete: ");
		phone_No = sc.next(); 
		ps = con.prepareStatement("delete from event where phone_No=?");
		ps.setString(1, phone_No);
		int i=ps.executeUpdate();
		if(i>0)
		{
			System.out.println("Deleted Successfully");
		}
		else
		{
			System.out.println("No such Record found in the Database");
		}
			
	}
	public void readCustomerDetails() throws SQLException
	{
		st=con.createStatement();
		System.out.println("View All The Data From The Database: ");
		rs=st.executeQuery("\nSelect * from event");
		while(rs.next())
		{
			System.out.print(rs.getInt(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.print(rs.getString(3)+"\t");
			System.out.print(rs.getString(4)+"\t");
			System.out.print(rs.getString(5)+"\t");
			System.out.print(rs.getString(6)+"\t");
			System.out.print(rs.getString(7)+"\t");
			System.out.print(rs.getString(8)+"\t");
			System.out.print(rs.getString(9));
			System.out.println();
		}
		con.close();
	}
}
