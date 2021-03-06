package com.movieapp.dao;

import java.util.List;

import com.movieapp.DbException;
import com.movieapp.model.TheatreList;

public interface TheatreListDAO {
	
    void addTheatreDetails(TheatreList list) throws DbException;
    
    void deleteTheatreDetails(int theatreId) throws DbException;
    
    void updateTheatreRating(int theatreRating, String theatreName) throws DbException;
    
    List<TheatreList> allTheatreDetails() throws DbException;

    List<TheatreList> getTheatreName(String theatreAddress) throws DbException;

	
	
}
