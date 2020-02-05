package com.movieapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.movieapp.DbConnection;
import com.movieapp.dao.MovieTheatreDAO;
import com.movieapp.model.MovieTheatre;

public class MovieTheatreDAOImpl implements MovieTheatreDAO {
	

	public void addMovieTheatre(MovieTheatre theatre) throws Exception {
		
		Connection con=DbConnection.getConnection();
		String sql="insert into movie_theatre(movie_theatre_id,movie_id,theatre_id,active,price,movie_timing)values(movie_theatre_id_seq.nextval,?,?,?,?,?)";
		System.out.println("");
		//System.out.println(sql);
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1,theatre.movieId);
		pst.setInt(2,theatre.theatreId);
		pst.setInt(3,theatre.active);
		pst.setInt(4,theatre.price);
		pst.setString(5,theatre.movieTiming.toString());
		int row=pst. executeUpdate();
		System.out.println(row);
		con.close();

		
	}

	public void updateMovieTheatre(int movieTheatreId,String movieTiming) throws Exception {
		// TODO Auto-generated method stub
		Connection con=DbConnection.getConnection();
		String sql="update movie_theatre set movie_timing=? where movie_theatre_id=?";
		System.out.println("");
		//System.out.println(sql);
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1,movieTiming.toString());
		pst.setInt(2,movieTheatreId);
		
		int row=pst. executeUpdate();
		System.out.println(row);
		con.close();
		
	}

	public void deleteMovieTheatre(int movieTheatreId) throws Exception {
		// TODO Auto-generated method stub
		Connection con=DbConnection.getConnection();
		String sql="delete from  movie_theatre where movie_theatre_id=?";
		System.out.println("");
		//System.out.println(sql);
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1,movieTheatreId);
		int row=pst. executeUpdate();
		System.out.println(row);
		con.close();
		
	}
		
	public List<MovieTheatre> getTheatreDetails(int movieId) throws Exception {

		List<MovieTheatre> list = new ArrayList<MovieTheatre>();
		Connection con=DbConnection.getConnection();
		String sql="Select movie_theatre_id,movie_id,theatre_id,active,price,movie_timing from movie_theatre where movie_id=?";
		System.out.println("");
		//System.out.println(sql);
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1,movieId);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
	    {
			MovieTheatre ml = new MovieTheatre();
			ml.movieTheatreId=rs.getInt("movie_theatre_id");
			ml.movieId=rs.getInt("movie_id");
			ml.theatreId=rs.getInt("theatre_id");
			ml.active=rs.getInt("active");
			ml.price=rs.getInt("price");
			ml.movieTiming=LocalTime.parse(rs.getString("movie_timing"));
			list.add(ml);
		}
		con.close();
		return list;
	}

	public void updateMoviePrice(int price,int movieTheatreId) throws Exception {
		// TODO Auto-generated method stub
		Connection con=DbConnection.getConnection();
		String sql="update movie_theatre set price=? where movie_theatre_id=?";
		System.out.println("");
		//System.out.println(sql);
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1,price);
		pst.setInt(2,movieTheatreId);
		int row=pst. executeUpdate();
		System.out.println(row);
		con.close();
		
	}

	public List<MovieTheatre> getMovieTiming(String theatreName) throws Exception {
		
		List<MovieTheatre> list = new ArrayList<MovieTheatre>();
		Connection con=DbConnection.getConnection();
		String sql="select movie_id,movie_timing from movie_theatre where theatre_id in(select theatre_id from theatre where theatre_name=?)";
		System.out.println(sql);
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1,theatreName);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
	    {
			MovieTheatre tl = new MovieTheatre();
			tl.movieId=rs.getInt("movie_id");
			tl.movieTiming=LocalTime.parse(rs.getString("movie_timing"));
		    list.add(tl);
		}
		con.close();

		return list;
	}

	
	public List<MovieTheatre> getNumSeats(int movieId) throws Exception {
		// TODO Auto-generated method stub
		List<MovieTheatre> list = new ArrayList<MovieTheatre>();
		Connection con=DbConnection.getConnection();
		String sql="Select number_seats from movie_theatre where movie_id=?";
		System.out.println(sql);
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1,movieId);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
	    {
			MovieTheatre ml = new MovieTheatre();
			ml.movieTheatreId=rs.getInt("movie_theatre_id");
			ml.movieId=rs.getInt("movie_id");
			ml.theatreId=rs.getInt("theatre_id");
			ml.active=rs.getInt("active");
			ml.price=rs.getInt("price");
			ml.movieTiming=rs.getTime("movie_timing").toLocalTime();
			list.add(ml);
		}
		con.close();
		return list;
	
	}

	public void updateMovieStatus(int active, int movieTheatreId) throws Exception {
		
		Connection con=DbConnection.getConnection();
		String sql="update movie_theatre set active=? where movie_theatre_id=?";
		System.out.println("");
		System.out.println(sql);
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1,active);
		pst.setInt(2,movieTheatreId);
		int row=pst. executeUpdate();
		System.out.println(row);
		con.close();	
	}

	
}
			