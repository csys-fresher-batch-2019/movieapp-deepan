package com.movieapp.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.movieapp.DbConnection;
import com.movieapp.dao.MovieListDAO;
import com.movieapp.model.MovieList;
import com.movieapp.model.MovieTheatre;

public class MovieListDAOImpl implements MovieListDAO {

	public void addMovie(MovieList movie) throws Exception {
		
		Connection con = DbConnection.getConnection();
		String sql = "insert into movie(movie_id,movie_name,movie_type,movie_language,movie_rating,movie_duration,released_date)values(movie_id_seq.nextval,?,?,?,?,?,?)";
		System.out.println("");
		//System.out.println(sql);
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, movie.movieName);
		pst.setString(2, movie.movieType);
		pst.setString(3, movie.movieLanguage);
		pst.setInt(4, movie.movieRating);
		pst.setInt(5, movie.movieDuration);
		pst.setDate(6, Date.valueOf(movie.releasedDate));
		int row = pst.executeUpdate();
		System.out.println(row);
		con.close();

	}
	
	public void updateMovieName(String movieName,String movieType,String movieLanguage,int movieRating,int movieDuration,String releasedDate, int movieId) throws Exception {
		
		Connection con = DbConnection.getConnection();
		String sqlb = "update movie set movie_name=?,movie_type=?,movie_language=?,movie_rating=?,movie_duration=?,released_date=? where movie_id=?";
		System.out.println("");
		//System.out.println(sqlb);
		PreparedStatement pst = con.prepareStatement(sqlb);
		pst.setString(1, movieName);
		pst.setString(2, movieType);
		pst.setString(3, movieLanguage);
		pst.setInt(4, movieRating);
		pst.setInt(5, movieDuration);
		pst.setString(6, releasedDate);
        pst.setInt(7, movieId);
		int rowb = pst.executeUpdate();
		System.out.println(rowb);
		con.close();

	}
	
	
	public void deleteMovieList(int movieId) throws Exception {
	
		Connection con = DbConnection.getConnection();
		String sql = "delete from movie where movie_id=?";
		System.out.println("");
		//System.out.println(sql);
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1,movieId);
		int row = stmt.executeUpdate();
		System.out.println(row);
		con.close();

	}

	public List<MovieList> getmovieName(String movieLanguage,String movieType) throws Exception {
		
		List<MovieList> list=new ArrayList<MovieList>();
		Connection con = DbConnection.getConnection();
		String sqla = "Select movie_name from movie where movie_language=? and movie_type=?";
		//System.out.println(sqla);
		System.out.println("");
		PreparedStatement stmta = con.prepareStatement(sqla);
		stmta.setString(1, movieLanguage);
		stmta.setString(2, movieType);
		ResultSet rs = stmta.executeQuery();
		while (rs.next()) 
		{
			MovieList ml = new MovieList();
			ml.movieName = rs.getString("movie_name");
			list.add(ml);
		}
		con.close();
		return list;
	}


    public List<MovieList> allMovieList() throws Exception {
		
		List<MovieList> list = new ArrayList<MovieList>();
		Connection con = DbConnection.getConnection();
		String sqla = "select movie_name,released_date from movie order by released_date desc";
		System.out.println("");
		//System.out.println(sqla);
		Statement stmta = con.createStatement();
		ResultSet rs = stmta.executeQuery(sqla);
		while (rs.next()) {
			MovieList ml = new MovieList();
			ml.movieName = rs.getString("movie_name");
			Date rd = rs.getDate("released_date");
			if (rd != null) {
				LocalDate ld = rd.toLocalDate();
				ml.releasedDate = ld;
			}
			list.add(ml);
		}
		con.close();
		return list;

	}

		public List<MovieList> allMovieDetails() throws Exception {

		List<MovieList> list = new ArrayList<MovieList>();
		Connection con = DbConnection.getConnection();
		String sqla = "Select * from movie";
		System.out.println("");
		//System.out.println(sqla);
		Statement stmta = con.createStatement();
		ResultSet rs = stmta.executeQuery(sqla);
		while (rs.next()) {
			MovieList ml = new MovieList();
			ml.movieId = rs.getInt("movie_id");
			ml.movieName = rs.getString("movie_name");
			ml.movieType = rs.getString("movie_type");
			ml.movieLanguage = rs.getString("movie_language");
			ml.movieRating = rs.getInt("movie_rating");
			ml.movieDuration = rs.getInt("movie_duration");
			Date rd = rs.getDate("released_date");
			if (rd != null) {
				LocalDate ld = rd.toLocalDate();
				ml.releasedDate = ld;
			}
			list.add(ml);
		}
		con.close();
		return list;
	}

	
}
