package com.movieapp.model;

//import java.sql.Date;
//import java.time.LocalDate;
import java.time.LocalDate;

public class MovieList {
	public int movieId;
	public String movieName;
	public String movieType;
	public String movieLanguage;
	public int movieRating;
	public int movieDuration;
	public LocalDate releasedDate;
	
	@Override
	public String toString() {
		return "MovieList [movieId=" + movieId + ", movieName=" + movieName + ", movieType=" + movieType
				+ ", movieLanguage=" + movieLanguage + ", movieRating=" + movieRating + ", movieDuration="
				+ movieDuration + ", releasedDate=" + releasedDate+ "]";
	}
	
	

}
