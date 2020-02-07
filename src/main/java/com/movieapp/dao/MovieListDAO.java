package com.movieapp.dao;

import java.util.List;

import com.movieapp.model.MovieList;
import com.movieapp.model.MovieTheatre;

public interface MovieListDAO {
	
	void addMovie(MovieList List) throws Exception;
	
    void updateMovieName(String movieName,String movieType,String movieLanguage,int movieRating,int movieDuration,String releasedDate, int movieId) throws Exception;
	
	void deleteMovieList(int movieId)throws Exception;
    
    List<MovieList> getmovieName(String movieLanguage,String movieType) throws Exception;
    
    List<MovieList> allMovieDetails(String movieName) throws Exception;
    
	List<MovieList> allMovieList() throws Exception;
	
	

}
