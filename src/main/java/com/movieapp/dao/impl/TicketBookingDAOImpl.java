package com.movieapp.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.movieapp.DbConnection;
import com.movieapp.DbException;
import com.movieapp.dao.TicketBookingDAO;
import com.movieapp.model.TicketBooking;

public class TicketBookingDAOImpl implements TicketBookingDAO {

	
	
public void addBookingDetails(TicketBooking booked) throws DbException {
		String sql = "insert into booked(movie_theatre_id,booked_id,users_id,booked_seats,amount,show_date)values(?,booked_id.nextval,?,?,?,?)";
		// System.out.println(sql);
		try (Connection con = DbConnection.getConnection(); 
			 PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, booked.getMovieTheaterId());
			// pst.setInt(2,booked.bookedId);
			pst.setInt(2, booked.getUsersId());
			pst.setInt(3, booked.getBookedSeats());
			pst.setInt(4, booked.getAmount());
			//pst.setLong(5, booked.getMobileNum());
			pst.setDate(5,Date.valueOf( booked.getShowDate()));
			int row = pst.executeUpdate();
			//System.out.println(row);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	

public void deleteBookingDetails(int usersId) throws DbException {
		String sql = "delete from booked where users_id=?";
		// System.out.println(sql);
		try (Connection con = DbConnection.getConnection(); 
			 PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, usersId);
			int row = pst.executeUpdate();
			System.out.println(row);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	

public int getPrice(int movieTheatreId) throws DbException {
		String sql = "Select price from movie_theatre where movie_theatre_id=?";
		System.out.println("");
		// System.out.println(sql);
		int a=0;
		try (Connection con = DbConnection.getConnection(); 
			 PreparedStatement pst = con.prepareStatement(sql))
		{
			
			pst.setInt(1, movieTheatreId);
		try(ResultSet rs = pst.executeQuery())
			  {
			
			
			if (rs.next()) {
				 a = rs.getInt("price");
			}
			//return a;
		}} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;

	}

	

public Long getMobileNumber(int usersId) throws DbException {
		String sql = "select mobile_num from users where user_id in (select users_id from booked where users_id=?)";
		System.out.println("");
		// System.out.println(sql);
		Long a=null;
		try (Connection con = DbConnection.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			) {
			pst.setInt(1, usersId);
			a = (long) 0;
			try(ResultSet rs = pst.executeQuery();){
			if (rs.next()) {
				a = rs.getLong("mobile_num");

			}
			}} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

}
