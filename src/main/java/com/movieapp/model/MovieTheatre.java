package com.movieapp.model;

import java.time.LocalTime;
import java.util.Timer;

public class MovieTheatre {
	public int movieTheatreId;
	public int movieId;
    public int theatreId;
    public int active;
    public int price;
    public LocalTime movieTiming;
	@Override
	public String toString() {
		return "MovieTheatre [movieTheatreId=" + movieTheatreId + ", movieId=" + movieId + ", theatreId=" + theatreId
				+ ", active=" + active + ", price=" + price + ", movieTiming=" + movieTiming + "]";
	}
    
    
}
