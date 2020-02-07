package com.movieapp.model;

import java.util.Date;

public class TicketBooking {
	private int movieTheaterId;
	private int bookedId;
	private int usersId;
	private int bookedSeats;
	private int amount;
	private String paymentStatus;
	private Date bookedDate;
	private Long mobileNum;
	@Override
	public String toString() {
		return "TicketBooking [movieTheaterId=" + getMovieTheaterId() + ", bookedId=" + bookedId + ", usersId=" + getUsersId()
				+ ", bookedSeats=" + getBookedSeats() + ", amount=" + getAmount() + ", paymentStatus=" + getPaymentStatus()
				+ ", bookedDate=" + bookedDate + ", mobileNum=" + getMobileNum() + "]";
	}
	public int getMovieTheaterId() {
		return movieTheaterId;
	}
	public void setMovieTheaterId(int movieTheaterId) {
		this.movieTheaterId = movieTheaterId;
	}
	public int getUsersId() {
		return usersId;
	}
	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}
	/**
	 * @return the bookedSeats
	 */
	public int getBookedSeats() {
		return bookedSeats;
	}
	/**
	 * @param bookedSeats the bookedSeats to set
	 */
	public void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
	}
	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	/**
	 * @return the paymentStatus
	 */
	public String getPaymentStatus() {
		return paymentStatus;
	}
	/**
	 * @param paymentStatus the paymentStatus to set
	 */
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	/**
	 * @return the mobileNum
	 */
	public Long getMobileNum() {
		return mobileNum;
	}
	/**
	 * @param mobileNum the mobileNum to set
	 */
	public void setMobileNum(Long mobileNum) {
		this.mobileNum = mobileNum;
	}
}
