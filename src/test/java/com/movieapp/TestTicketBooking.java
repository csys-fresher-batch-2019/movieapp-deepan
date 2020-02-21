package com.movieapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.movieapp.dao.impl.BookedMail;
import com.movieapp.dao.impl.TicketBookingDAOImpl;
import com.movieapp.dao.impl.UserInformationImpl;
import com.movieapp.model.TicketBooking;

public class TestTicketBooking {

	public static void main(String[] args) throws Exception {

		// testInsert();
		// testDelete();
		// testBookedDetails();
		// testgetPrice();
		/*
		 * TicketBookingDAOImpl impl=new TicketBookingDAOImpl(); impl.cancelTicket(124);
		 */

	}

	public static void testInsert() throws Exception {
		TicketBookingDAOImpl impl = new TicketBookingDAOImpl();
		Scanner sc = new Scanner(System.in);
		TicketBooking tb = new TicketBooking();
		System.out.println("Enter the Movie theatre Id");
		tb.setMovieTheaterId(sc.nextInt());
		System.out.println("Enter the users Id");
		tb.setUsersId(sc.nextInt());

		System.out.println("Enter the Number of Seats");
		tb.setBookedSeats(sc.nextInt());

		System.out.println("Enter the show date");
		tb.setShowDate(LocalDate.parse(sc.next()));

		int a = impl.getPrice(tb.getMovieTheaterId());
		System.out.println("Movie Ticket Price:" + a);
		tb.setAmount(tb.getBookedSeats() * a);
		System.out.println(tb.getBookedSeats() + " Movie Ticket Price:" + tb.getAmount());

		// int bookingId = 0;
		impl.addBookingDetails(tb);
		System.out.println(tb);

		System.out.println("Do You Want To Send Mail:(yes/no)");
		UserInformationImpl ui = new UserInformationImpl();
		String Email = ui.getEmailId(tb.getUsersId());
		String s = sc.next();
		if (s.equals("yes")) {
			BookedMail.send("movieappservice@gmail.com", "Deepan@123", Email, "Booking Details", "Successfully booked",
					1, tb.getUsersId(), tb.getMovieTheaterId(), tb.getBookedSeats(), tb.getAmount());
			System.out.println(Email + " Mail sent Successfully");
		} else
			System.out.println("Ticket Booked");
	}

	public static void testDelete() throws DbException {
		Scanner sc = new Scanner(System.in);
		TicketBooking tb = new TicketBooking();
		System.out.println("Enter the Movie users Id");
		tb.setUsersId(sc.nextInt());

		TicketBookingDAOImpl impl = new TicketBookingDAOImpl();
		impl.deleteBookingDetails(tb.getUsersId());

	}

	public static void testgetPrice() throws DbException {

		TicketBookingDAOImpl t = new TicketBookingDAOImpl();
		int amount = t.getPrice(116);
		System.out.println(amount);
	}

	public static void testBookedDetails() throws DbException

	{

		TicketBookingDAOImpl obj = new TicketBookingDAOImpl();
		List<TicketBooking> list = new ArrayList<TicketBooking>();
		list = obj.getUserBookedDetails(11195);
		System.out.println(list);
		for (TicketBooking Tb : list) {
			System.out.println(Tb);

		}
	}
}
