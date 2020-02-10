package com.movieapp.dao;

import java.util.List;

import com.movieapp.DbException;
import com.movieapp.model.MovieList;
import com.movieapp.model.MovieTheatre;

public interface MovieListDAO {
	
	void addMovie(MovieList List) throws DbException;
	
    void updateMovieName(String movieName,String movieType,String movieLanguage,int movieRating,int movieDuration,String releasedDate, int movieId) throws Exception;
	
	void deleteMovieList(int movieId)throws DbException;
    
    List<MovieList> getmovieName(String movieLanguage,String movieType) throws DbException;
    
    List<MovieList> allMovieDetails(String movieName) throws DbException;
    
	List<MovieList> allMovieList() throws DbException;
	
	

}
