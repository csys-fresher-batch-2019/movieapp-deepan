package com.movieapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.movieapp.DbConnection;
import com.movieapp.dao.MovieTheatreDAO;
import com.movieapp.dao.TheatreListDAO;
import com.movieapp.model.TheatreList;

	public class TheatreListDAOImpl implements TheatreListDAO {

		public void addTheatreDetails(TheatreList theatre) throws Exception {
			// TODO Auto-generated method stub
			Connection con=DbConnection.getConnection();
			String sql="insert into theatre(theatre_name,theatre_id,number_seats,theatre_address,theatre_rating)values(?,theatre_id_seq.nextval,?,?,?)";
			//System.out.println(sql);
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,theatre.theatreName);
			pst.setInt(2,theatre.numberSeats);
			pst.setString(3,theatre.theatreAddress);
			pst.setInt(4,theatre.theatreRating);
			int row=pst. executeUpdate();
			System.out.println(row);
            con.close();
			
		}

		public void deleteTheatreDetails(int theatreId) throws Exception {
			// TODO Auto-generated method stub
			Connection con=DbConnection.getConnection();
			String sql="delete from theatre where theatre_id=?";
			//System.out.println(sql);
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1,theatreId);
			int row=pst. executeUpdate();
			System.out.println(row);
			con.close();
			
		}

		public void updateTheatreRating(int theatreRating,String theatreName) throws Exception {
			// TODO Auto-generated method stub
			Connection con=DbConnection.getConnection();
			String sql="update theatre set theatre_rating=? where theatre_name=?";
			//System.out.println(sql);
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1,theatreRating);
			pst.setString(2,theatreName);
			int row=pst. executeUpdate();
			System.out.println(row);
			con.close();
			
		}

		public List<TheatreList> allTheatreDetails() throws Exception {
			
		   List <TheatreList> list=new ArrayList<TheatreList>();
			Connection con=DbConnection.getConnection();
			String sql="Select theatre_name,theatre_id,number_seats,theatre_address,theatre_rating from theatre";
			//System.out.println(sql);
			System.out.println("");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
		    {
				TheatreList tl=new TheatreList();
				tl.theatreName=rs.getString("theatre_name");
				tl.theatreId=rs.getInt("theatre_id");
				tl.numberSeats=rs.getInt("number_seats");
				tl.theatreAddress=rs.getString("theatre_address");
				tl.theatreRating=rs.getInt("theatre_rating");
                list.add(tl);
		    }
			con.close();
		
			return list;
		}

		public List<TheatreList> getTheatreName(String theatreAddress) throws Exception {
			List<TheatreList> list=new ArrayList<TheatreList>();
			Connection con=DbConnection.getConnection();
			String sql="Select theatre_name from theatre where theatre_address like ?";
			//System.out.println(sql);
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, "%"+theatreAddress+"%");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
		    {
				TheatreList tl=new TheatreList();
				tl.theatreName=rs.getString("theatre_name");
				list.add(tl);
		    }
			return list;
		}

		
	}

