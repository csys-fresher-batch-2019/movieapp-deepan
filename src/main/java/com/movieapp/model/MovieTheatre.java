package com.movieapp.model;

import java.time.LocalTime;
import java.util.Timer;

public class MovieTheatre {
	private int movieTheatreId;
	private int movieId;
	private int theatreId;
	private int active;
	private int price;
	private LocalTime movieTiming;
	@Override
	public String toString() {
		return "MovieTheatre [movieTheatreId=" + getMovieTheatreId() + ", movieId=" + getMovieId() + ", theatreId=" + getTheatreId()
				+ ", active=" + getActive() + ", price=" + getPrice() + ", movieTiming=" + getMovieTiming() + "]";
	}
	/**
	 * @return the movieId
	 */
	public int getMovieId() {
		return movieId;
	}
	/**
	 * @param movieId the movieId to set
	 */
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	/**
	 * @return the theatreId
	 */
	public int getTheatreId() {
		return theatreId;
	}
	/**
	 * @param theatreId the theatreId to set
	 */
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	/**
	 * @return the active
	 */
	public int getActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(int active) {
		this.active = active;
	}
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * @return the movieTiming
	 */
	public LocalTime getMovieTiming() {
		return movieTiming;
	}
	/**
	 * @param movieTiming the movieTiming to set
	 */
	public void setMovieTiming(LocalTime movieTiming) {
		this.movieTiming = movieTiming;
	}
	/**
	 * @return the movieTheatreId
	 */
	public int getMovieTheatreId() {
		return movieTheatreId;
	}
	/**
	 * @param movieTheatreId the movieTheatreId to set
	 */
	public void setMovieTheatreId(int movieTheatreId) {
		this.movieTheatreId = movieTheatreId;
	}
    
    
}
