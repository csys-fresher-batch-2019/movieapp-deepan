package com.movieapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.movieapp.DbConnection;
import com.movieapp.dao.TicketBookingDAO;
import com.movieapp.model.TicketBooking;

public class TicketBookingDAOImpl implements TicketBookingDAO {

	public void addBookingDetails(TicketBooking booked) throws Exception {
		// TODO Auto-generated method stub
		Connection con=DbConnection.getConnection();
		String sql="insert into booked(movie_theatre_id,booked_id,users_id,booked_seats,amount,payment_status,mobile_num)values(?,booked_id.nextval,?,?,?,?,?)";
		//System.out.println(sql);
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1,booked.movieTheaterId);
		//pst.setInt(2,booked.bookedId);
		pst.setInt(2,booked.usersId);
		pst.setInt(3,booked.bookedSeats);
		pst.setInt(4, booked.amount);
		pst.setString(5,booked.paymentStatus);
		pst.setLong(6, booked.mobileNum);
		int row=pst. executeUpdate();
		System.out.println(row);

		
	}

	public void deleteBookingDetails(int usersId) throws Exception {
		// TODO Auto-generated method stub
		Connection con=DbConnection.getConnection();
		String sql="delete from booked where users_id=?";
		//System.out.println(sql);
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1,usersId);
		int row=pst. executeUpdate();
		System.out.println(row);

		
	}

	public int getPrice(int movieTheatreId) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DbConnection.getConnection();
		String sql= "Select price from movie_theatre where movie_theatre_id=?";
		System.out.println("");
		//System.out.println(sql);
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, movieTheatreId);
		ResultSet rs = pst.executeQuery();
		int a=0;
		if (rs.next()) {
			a=rs.getInt("price");
			
		}
		return a;
	}

	public Long getMobileNumber(int usersId) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DbConnection.getConnection();
		String sql= "select mobile_num from users where user_id in (select users_id from booked where users_id=?)";
		System.out.println("");
		//System.out.println(sql);
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, usersId);
		ResultSet rs = pst.executeQuery();
		Long a=(long) 0;
		if (rs.next()) {
			a=rs.getLong("mobile_num");
			
		}
		return a;
	}

	

}
