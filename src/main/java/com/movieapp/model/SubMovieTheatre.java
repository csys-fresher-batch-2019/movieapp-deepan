package com.movieapp.model;

public class SubMovieTheatre {
	public String movieName;
	public String theatreName;
	public int availableSeats;
	
	@Override
	public String toString() {
		return "SubMovieTheatre [movieName=" + movieName + ", theatreName=" + theatreName + ", availableSeats="
				+ availableSeats + "]";
	}

}
