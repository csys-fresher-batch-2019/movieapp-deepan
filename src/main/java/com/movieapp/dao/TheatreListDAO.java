package com.movieapp.dao;

import java.util.List;

import com.movieapp.model.TheatreList;

public interface TheatreListDAO {
	
    void addTheatreDetails(TheatreList list) throws Exception;
    
    void deleteTheatreDetails(int theatreId) throws Exception;
    
    void updateTheatreRating(int theatreRating, String theatreName) throws Exception;
    
    List<TheatreList> allTheatreDetails() throws Exception;

    List<TheatreList> getTheatreName(String theatreAddress) throws Exception;

	
	
}
