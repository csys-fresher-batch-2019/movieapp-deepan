package com.movieapp.dao;

import com.movieapp.model.TicketBooking;


public interface TicketBookingDAO {
	
    void addBookingDetails(TicketBooking list) throws Exception;
    void deleteBookingDetails(int userId) throws Exception;
    int getPrice(int movieTheatreId) throws Exception;


}
