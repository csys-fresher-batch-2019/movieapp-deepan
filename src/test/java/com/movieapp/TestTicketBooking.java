package com.movieapp;

import java.util.Scanner;

import com.movieapp.dao.impl.BookedMail;
import com.movieapp.dao.impl.TicketBookingDAOImpl;
import com.movieapp.model.TicketBooking;


public class TestTicketBooking {

	public static void main(String[] args) throws Exception {

		testInsert();
		//testDelete();
		
		


	}
	public static void testInsert() throws Exception
	{
		TicketBookingDAOImpl impl=new TicketBookingDAOImpl();
		Scanner sc=new Scanner(System.in);
		TicketBooking tb= new TicketBooking();
		System.out.println("Enter the Movie theatre Id");
		tb.movieTheaterId=sc.nextInt();
		System.out.println("Enter the users Id");
		tb.usersId=sc.nextInt();
		System.out.println("Enter the booked Seats");
		tb.bookedSeats=sc.nextInt();
		System.out.println("Enter the payment status");
		tb.paymentStatus=sc.next();
		
		
		int a=impl.getPrice(tb.movieTheaterId);
		System.out.println("Movie Ticket Price:"+a);
		tb.amount=tb.bookedSeats*a;
		System.out.println(tb.bookedSeats +" Movie Ticket Price:"+tb.amount);
		Long b=(long) impl.getMobileNumber(tb.usersId);
		tb.mobileNum=b;
		
		impl.addBookingDetails(tb);
		System.out.println(tb);
		
		System.out.println("Do You Want To Send Mail:(yes/no)");
		String s=sc.next();
		if(s.equals("yes"))
		{
			BookedMail.send("payrollmavenproject@gmail.com","Pass1234*","deepanraj151997@gmail.com", "Booking Details", "Successfully booked", 1,11156,115,2,300);
System.out.println("Mail sent Successfully");
		}
		else
			System.out.println("Ticket Booked");
	}
	
	public static void testDelete() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		TicketBooking tb= new TicketBooking();
		System.out.println("Enter the Movie users Id");
		tb.usersId=sc.nextInt();
		
		TicketBookingDAOImpl impl=new TicketBookingDAOImpl();
		impl.deleteBookingDetails(tb.usersId);
		
	}
}
		
