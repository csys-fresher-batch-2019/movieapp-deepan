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
		tb.setMovieTheaterId(sc.nextInt());
		System.out.println("Enter the users Id");
		tb.setUsersId(sc.nextInt());
		System.out.println("Enter the booked Seats");
		tb.setBookedSeats(sc.nextInt());
		System.out.println("Enter the payment status");
		tb.setPaymentStatus(sc.next());
		
		
		int a=impl.getPrice(tb.getMovieTheaterId());
		System.out.println("Movie Ticket Price:"+a);
		tb.setAmount(tb.getBookedSeats()*a);
		System.out.println(tb.getBookedSeats() +" Movie Ticket Price:"+tb.getAmount());
		Long b=(long) impl.getMobileNumber(tb.getUsersId());
		tb.setMobileNum(b);
		
		impl.addBookingDetails(tb);
		System.out.println(tb);
		
		System.out.println("Do You Want To Send Mail:(yes/no)");
		String s=sc.next();
		if(s.equals("yes"))
		{
			BookedMail.send("movieappservice@gmail.com","Deepan@123","ajamlahamed@gmail.com", "Booking Details", "Successfully booked", 1,11156,115,2,300);
System.out.println("Mail sent Successfully");
		}
		else
			System.out.println("Ticket Booked");
	}
	
	public static void testDelete() throws DbException
	{
		Scanner sc=new Scanner(System.in);
		TicketBooking tb= new TicketBooking();
		System.out.println("Enter the Movie users Id");
		tb.setUsersId(sc.nextInt());
		
		TicketBookingDAOImpl impl=new TicketBookingDAOImpl();
		impl.deleteBookingDetails(tb.getUsersId());
		
	}
}
		
