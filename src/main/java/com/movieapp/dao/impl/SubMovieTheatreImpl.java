package com.movieapp.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.movieapp.DbConnection;
import com.movieapp.model.SubMovieTheatre;

public class SubMovieTheatreImpl {

	
	public List <SubMovieTheatre> getAvailableSeats()throws Exception
	{
		List<SubMovieTheatre> list=new ArrayList<SubMovieTheatre>();
		Connection con = DbConnection.getConnection();
		String sqla = "SELECT M.MOVIE_NAME, T.THEATRE_NAME, (  T.NUMBER_SEATS - ( select nvl(SUM(B.BOOKED_SEATS),0) FROM BOOKED B WHERE B.movie_theatre_id = MT.movie_theatre_id))   AS AVAILABLE_SEATS FROM \r\n" + 
				"THEATRE T, MOVIE_THEATRE MT,MOVIE M\r\n" + 
				"WHERE m.movie_id = mt.movie_id AND t.theatre_id = MT.THEATRE_ID";
		System.out.println("");
		//System.out.println(sqla);
		Statement stmta = con.createStatement();
		ResultSet rs = stmta.executeQuery(sqla);
		while (rs.next()) {
			
			SubMovieTheatre sm = new SubMovieTheatre();
			sm.movieName=rs.getString("movie_name");
			sm.theatreName=rs.getString("theatre_name");
			sm.availableSeats=rs.getInt("AVAILABLE_SEATS");
			list.add(sm);
		}

		return list;
		
	}
	
	
}
