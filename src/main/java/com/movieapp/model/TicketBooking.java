package com.movieapp.model;

import java.util.Date;

public class TicketBooking {
	public int movieTheaterId;
	public int bookedId;
	public int usersId;
	public int bookedSeats;
	public int amount;
	public String paymentStatus;
	public Date bookedDate;
	public Long mobileNum;
	@Override
	public String toString() {
		return "TicketBooking [movieTheaterId=" + movieTheaterId + ", bookedId=" + bookedId + ", usersId=" + usersId
				+ ", bookedSeats=" + bookedSeats + ", amount=" + amount + ", paymentStatus=" + paymentStatus
				+ ", bookedDate=" + bookedDate + ", mobileNum=" + mobileNum + "]";
	}
}
