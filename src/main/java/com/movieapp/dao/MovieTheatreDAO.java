package com.movieapp.dao;

import java.time.LocalTime;
import java.util.List;

import com.movieapp.model.MovieTheatre;
import com.movieapp.model.TheatreList;

public interface MovieTheatreDAO {
	
	void addMovieTheatre(MovieTheatre list) throws Exception;
	
	void updateMovieTheatre(int movieTheatreId,String movieTiming) throws Exception;
	
	void deleteMovieTheatre(int movieTheatreId) throws Exception;
	
	void updateMoviePrice(int price,int movieTheatreId) throws Exception;
	
	void updateMovieStatus(int active,int movieTheatreId) throws Exception;
	
    List<MovieTheatre> getTheatreDetails(int movieId) throws Exception;
  
    List<MovieTheatre> getMovieTiming(String theatreName) throws Exception;

    List<MovieTheatre> getNumSeats(int movieId) throws Exception ;
}
