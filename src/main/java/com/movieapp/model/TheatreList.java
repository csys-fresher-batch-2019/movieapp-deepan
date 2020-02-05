package com.movieapp.model;

public class TheatreList {
	public String theatreName;
	public int theatreId;
	public int numberSeats;
	public String theatreAddress;
	public int theatreRating;
	@Override
	public String toString() {
		return "TheatreList [theatreName=" + theatreName + ", theatreId=" + theatreId + ", numberSeats=" + numberSeats
				+ ", theatreAddress=" + theatreAddress + ", theatreRating=" + theatreRating + "]";
	}

}
