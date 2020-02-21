package com.movieapp;

import java.util.ArrayList;
import java.util.List;

import com.movieapp.dao.impl.SubMovieTheatreImpl;
import com.movieapp.model.SubMovieTheatre;

public class TestSubMovieTheatre {

	public static void main(String[] args) throws DbException {

		testGetAvailableSeats();
	}

	private static void testGetAvailableSeats() throws DbException {
		SubMovieTheatreImpl obj = new SubMovieTheatreImpl();
		List<SubMovieTheatre> list = new ArrayList<SubMovieTheatre>();
		list = obj.getAvailableSeats();

		for (SubMovieTheatre movie : list) {
			System.out.println(movie);
		}
	}

}
