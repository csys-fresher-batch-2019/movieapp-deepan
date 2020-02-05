package com.movieapp.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.movieapp.DbConnection;
import com.movieapp.dao.JoinGetTotAmtDAO;
import com.movieapp.model.JoinGetTotalAmount;

public class JoinGetTotAmtDAOImpl implements JoinGetTotAmtDAO{

	public List<JoinGetTotalAmount> getTotalAmount() throws Exception {
		List<JoinGetTotalAmount> list=new ArrayList<JoinGetTotalAmount>();
		Connection con = DbConnection.getConnection();
		System.out.println("***Display the Total Amount***");
		String sqla = "select b.movie_theatre_id, mt.movie_id, mt.theatre_id, sum(amount) as total_amount from \r\n" + 
				"booked b, movie_theatre mt where mt.movie_theatre_id = b.movie_theatre_id \r\n" + 
				"group by b.movie_theatre_id, movie_id, theatre_id";
		System.out.println(sqla);
		Statement stmta = con.createStatement();
		ResultSet rs = stmta.executeQuery(sqla);
		while (rs.next()) {
			
			JoinGetTotalAmount ta = new JoinGetTotalAmount();
			ta.movieTheatreId=rs.getInt("movie_theatre_id");
			ta.movieId=rs.getInt("movie_id");
			ta.theatreId=rs.getInt("theatre_id");
			ta.totalAmount=rs.getInt("total_amount");
			list.add(ta);
		}
		return list;
	}

}
