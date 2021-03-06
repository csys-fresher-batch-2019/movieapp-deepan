package com.movieapp.dao;

import java.util.List;

import com.movieapp.DbException;
import com.movieapp.model.TicketBooking;


public interface TicketBookingDAO {
	
    void addBookingDetails(TicketBooking list) throws DbException;
    void deleteBookingDetails(int userId) throws DbException;
    int getPrice(int movieTheatreId) throws DbException;
    List<TicketBooking> getUserBookedDetails(int userId) throws DbException;
    void cancelTicket(String bookedId)throws DbException;


}
