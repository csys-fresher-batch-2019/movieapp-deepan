package com.movieapp;

import java.util.ArrayList;
import java.util.List;

import com.movieapp.dao.impl.SubMovieTheatreImpl;
import com.movieapp.model.SubMovieTheatre;

public class TestSubMovieTheatre {

	public static void main(String[] args) throws Exception {
		
		testGetAvailableSeats();
	}
	private static void testGetAvailableSeats() throws Exception
	{
		SubMovieTheatreImpl obj =  new  SubMovieTheatreImpl();
		//selectMovieName
		List<SubMovieTheatre> list=new ArrayList<SubMovieTheatre>();
		list=obj.getAvailableSeats();
		for(SubMovieTheatre movie:list)
		{
			System.out.println(movie);
		}
	}

}