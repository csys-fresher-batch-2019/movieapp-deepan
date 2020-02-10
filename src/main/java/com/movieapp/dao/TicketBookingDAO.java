package com.movieapp.dao;

import com.movieapp.DbException;
import com.movieapp.model.TicketBooking;


public interface TicketBookingDAO {
	
    void addBookingDetails(TicketBooking list) throws DbException;
    void deleteBookingDetails(int userId) throws DbException;
    int getPrice(int movieTheatreId) throws DbException;


}
