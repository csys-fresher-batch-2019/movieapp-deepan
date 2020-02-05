package com.movieapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestClass {

	public static void main(String[] args) throws Exception {
		
		String movieName="nanban";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		
		Statement stmt=connection.createStatement();
	
		String sql="insert into movies(movie_Name,movie_id)values('"+movieName+"',movie_id.nextval)";
		System.out.println(sql);
		int row=stmt. executeUpdate(sql);
		System.out.println(row);
		
		/*String sql="delete from movie where movie_id=444";
		System.out.println(sql);
		
		
		String sql="Select movie_name from movie";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next())
		{
		String movieName=rs.getString("movie_name");
		System.out.println(movieName);

		}
		
		
			String sql="update movie set movie_name='"+movieName+"' where movie_id="+movieId+"";
			System.out.println(sql);
			int row=stmt. executeUpdate(sql);
			System.out.println(row);*/
		
		
		/*String sql="insert into movie(movie_Name,movie_Id,movie_Type,price)values('s',555,'Hindi',200)";
		System.out.println(sql);
		int row=stmt. executeUpdate(sql);
		System.out.println(row);*/
		
		
		/*String sql="delete from movie where movie_id=555";
		System.out.println(sql);
		int row=stmt. executeUpdate(sql);
		System.out.println(row);*/
		
		
		/*String sql="insert into movie(movie_Name,movie_id)values('"+movieName+"',movie_id.nextval)";
		System.out.println(sql);
		int row=stmt. executeUpdate(sql);
		System.out.println(row);*/
		
		
		
		
		
		
	}

	
	}


