package com.movieapp;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.movieapp.dao.impl.MovieListDAOImpl;
import com.movieapp.model.MovieList;


public class TestMovieList {
	
	public static void main(String[] args) throws Exception{
		
		//testAddMovie();
		//testUpdateMovie();
		//testDeleteMovie();
		//testGetmovieName();
		//testRecentMovies();
		testAllMovieDetails();
	}
	
    private static void testAddMovie() throws Exception {
		
		ArrayList<MovieList> List=new ArrayList<MovieList>();
		MovieList ml=new MovieList();
	
		ml.setMovieName("endru endrum punnagai");
		ml.setMovieDuration(3);
		ml.setMovieLanguage("Tamil");
		ml.setMovieRating(5);
		ml.setMovieType("comedy");
		ml.setReleasedDate(LocalDate.parse("2020-10-26"));
		List.add(ml);
		
	
		MovieListDAOImpl obj=new MovieListDAOImpl();
		List<MovieList> list=new ArrayList<MovieList>();
		
		for(MovieList movie:List)
		{
			obj.addMovie(movie);
			System.out.println(movie);
		}
	} 
    

	private static void testUpdateMovie() throws Exception 
	{
		Scanner sc=new Scanner(System.in);
		MovieListDAOImpl obj =  new  MovieListDAOImpl();
		System.out.println("### Update Movie Details ###");
		System.out.println("Enter Movie Id:");
		int movieId=sc.nextInt();
		System.out.println("Enter Movie Name:");
		String movieName=sc.next();
		System.out.println("Enter Movie Type:");
		String movieType=sc.next();
		System.out.println("Enter Movie Language:");
		String movieLanguage=sc.next();
		System.out.println("Enter Movie Rating:");
		int movieRating=sc.nextInt();
		System.out.println("Enter Movie Duration:");
		int movieDuration=sc.nextInt();
        System.out.println("Enter Released Date:");
		String releasedDate=sc.next();
        obj.updateMovieName(movieName,movieType,movieLanguage,movieRating,movieDuration,releasedDate,movieId);
	}
	
	
	private static void testDeleteMovie() throws Exception 
	{
		Scanner sc=new Scanner(System.in);
		MovieListDAOImpl obj =  new  MovieListDAOImpl();
		System.out.println("### Delete Movie Details ###");
		System.out.println("Enter Movie Id:");
		int movieId=sc.nextInt();
		obj.deleteMovieList(movieId);
	}
	
	                                                                     //language
	
	private static void testGetmovieName() throws Exception 
	{
		Scanner sc=new Scanner(System.in);
		MovieListDAOImpl obj =  new  MovieListDAOImpl();
		List<MovieList> list=new ArrayList<MovieList>();
		System.out.println("");
		System.out.println("### List Movie Names ###");
		System.out.println("Enter Movie Language (English/Tamil/Hindi/Telugu/Malayalam):");
		String movieLanguage=sc.next();
		System.out.println("Enter Movie Type(comedy/horror/action/historical/Romance)");
		String movieType=sc.next();
		list=obj.getmovieName(movieLanguage,movieType);
		for(MovieList movie:list)
		{
			System.out.println("[MovieName: "+movie.getMovieName()+"]");
		}
	}
	                                                             //recent released movie using date
	private static void testRecentMovies() throws Exception {
		Scanner sc=new Scanner(System.in);
		MovieListDAOImpl obj =  new  MovieListDAOImpl();
		System.out.println("### List Movie Name By Released Date ###");
		List<MovieList> list=obj.allMovieList();

		for(MovieList movie:list)
		{
			System.out.println("[MovieName: "+movie.getMovieName()+" , ReleasedDate: "+movie.getReleasedDate()+"]");
		}
	}
	
	private static void testAllMovieDetails() throws Exception 
	{
		//AllMovieList
				MovieListDAOImpl obj =  new  MovieListDAOImpl();
				List<MovieList> list=new ArrayList<MovieList>();
				System.out.println("***List All Movie Details***");
				list=obj.allMovieDetails("ch");
				for (MovieList movieList : list) 
				{
					System.out.println(movieList);
				}
	}
	

	

	
}
