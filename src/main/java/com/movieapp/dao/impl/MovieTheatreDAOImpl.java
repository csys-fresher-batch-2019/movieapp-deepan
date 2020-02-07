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
		String sql="insert into movie_theatre(movie_theatre_id,movie_id,theatre_id,active,price,movie_timing)values(movie_theatre_id_seq.nextval,?,?,?,?,?)";
		System.out.println("");
		//System.out.println(sql);
		try (	Connection con=DbConnection.getConnection();
				PreparedStatement pst=con.prepareStatement(sql);){
			pst.setInt(1,theatre.getMovieId());
			pst.setInt(2,theatre.getTheatreId());
			pst.setInt(3,theatre.getActive());
			pst.setInt(4,theatre.getPrice());
			pst.setString(5,theatre.getMovieTiming().toString());
			int row=pst. executeUpdate();
			System.out.println(row);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	public void updateMovieTheatre(int movieTheatreId,String movieTiming) throws Exception {
		String sql="update movie_theatre set movie_timing=? where movie_theatre_id=?";
		System.out.println("");
		//System.out.println(sql);
		try( Connection con=DbConnection.getConnection();
				PreparedStatement pst=con.prepareStatement(sql);)
		{
			pst.setString(1,movieTiming.toString());
			pst.setInt(2,movieTheatreId);
			
			int row=pst. executeUpdate();
			System.out.println(row);
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void deleteMovieTheatre(int movieTheatreId) throws Exception {
		String sql="delete from  movie_theatre where movie_theatre_id=?";
		System.out.println("");
		//System.out.println(sql);
		try (	Connection con=DbConnection.getConnection();
				PreparedStatement pst=con.prepareStatement(sql);)
		{
			pst.setInt(1,movieTheatreId);
			int row=pst. executeUpdate();
			System.out.println(row);
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	public List<MovieTheatre> getTheatreDetails(int movieId) throws Exception {

		List<MovieTheatre> list = new ArrayList<MovieTheatre>();
		String sql="Select movie_theatre_id,movie_id,theatre_id,active,price,movie_timing from movie_theatre where movie_id=?";
		System.out.println("");
		//System.out.println(sql);
		try(		Connection con=DbConnection.getConnection();
				    PreparedStatement pst=con.prepareStatement(sql);
				   ResultSet rs=pst.executeQuery();)
		{
			pst.setInt(1,movieId);
			while(rs.next())
			{
				MovieTheatre ml = new MovieTheatre();
				ml.setMovieTheatreId(rs.getInt("movie_theatre_id"));
				ml.setMovieId(rs.getInt("movie_id"));
				ml.setTheatreId(rs.getInt("theatre_id"));
				ml.setActive(rs.getInt("active"));
				ml.setPrice(rs.getInt("price"));
				ml.setMovieTiming(LocalTime.parse(rs.getString("movie_timing")));
				list.add(ml);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public void updateMoviePrice(int price,int movieTheatreId) throws Exception {
		String sql="update movie_theatre set price=? where movie_theatre_id=?";
		System.out.println("");
		//System.out.println(sql);
		try (	Connection con=DbConnection.getConnection();
				PreparedStatement pst=con.prepareStatement(sql);)
		{
			pst.setInt(1,price);
			pst.setInt(2,movieTheatreId);
			int row=pst. executeUpdate();
			System.out.println(row);
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<MovieTheatre> getMovieTiming(String theatreName) throws Exception {
		List<MovieTheatre> list = new ArrayList<MovieTheatre>();
		String sql="select movie_id,movie_timing from movie_theatre where theatre_id in(select theatre_id from theatre where theatre_name=?)";
		System.out.println(sql);
		try (	Connection con=DbConnection.getConnection();
				PreparedStatement pst=con.prepareStatement(sql);
				ResultSet rs=pst.executeQuery();)
		{
			System.out.println("deepan");
			pst.setString(1,theatreName);
			while(rs.next())
			{
				MovieTheatre tl = new MovieTheatre();
				tl.setMovieId(rs.getInt("movie_id"));
				tl.setMovieTiming(LocalTime.parse(rs.getString("movie_timing")));
			    list.add(tl);
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	
	public List<MovieTheatre> getNumSeats(int movieId) throws Exception {
		List<MovieTheatre> list = new ArrayList<MovieTheatre>();
		String sql="Select number_seats from movie_theatre where movie_id=?";
		System.out.println(sql);
		try (	Connection con=DbConnection.getConnection();
				PreparedStatement pst=con.prepareStatement(sql);
				ResultSet rs=pst.executeQuery();)
		{
			pst.setInt(1,movieId);
			while(rs.next())
			{
				MovieTheatre ml = new MovieTheatre();
				ml.setMovieTheatreId(rs.getInt("movie_theatre_id"));
				ml.setMovieId(rs.getInt("movie_id"));
				ml.setTheatreId(rs.getInt("theatre_id"));
				ml.setActive(rs.getInt("active"));
				ml.setPrice(rs.getInt("price"));
				ml.setMovieTiming(rs.getTime("movie_timing").toLocalTime());
				list.add(ml);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	
	}

	public void updateMovieStatus(int active, int movieTheatreId) throws Exception {
		String sql="update movie_theatre set active=? where movie_theatre_id=?";
		System.out.println("");
		System.out.println(sql);
		try (	Connection con=DbConnection.getConnection();
				PreparedStatement pst=con.prepareStatement(sql);)
		{
			pst.setInt(1,active);
			pst.setInt(2,movieTheatreId);
			int row=pst. executeUpdate();
			System.out.println(row);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	
}
			