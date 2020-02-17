package com.movieapp;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.movieapp.dao.impl.MovieTheatreDAOImpl;
import com.movieapp.model.MovieTheatre;
import com.movieapp.model.TheatreList;

public class TestMovieTheatre {
	
	

	public static void main(String[] args) throws DbException {
		
		testInsert();
		//testUpdateTime();
		//testDelete();
		//testGetTheatreDetails();
		//testUpdateMoviePrice();
		//testMovieTiming();
        //testUpdateMovieStatus();
		testActiveTheatre();
		
		
	}
		
	private static void testInsert() throws DbException {
		
		List<MovieTheatre> list = new ArrayList<MovieTheatre>();
        MovieTheatre mt=new MovieTheatre();
		
		mt.setMovieId(1001);
		mt.setTheatreId(1151);
		mt.setActive(1);
		mt.setPrice(100);
		mt.setMovieTiming(LocalTime.parse("03:00"));
		
        list.add(mt);
		
		MovieTheatreDAOImpl impl= new MovieTheatreDAOImpl();
	
	    for(MovieTheatre theatre:list)
		{
		impl.addMovieTheatre(theatre);
		
		}
	}
	private static void testUpdateTime() throws DbException {

		MovieTheatreDAOImpl impl= new MovieTheatreDAOImpl();
		List<MovieTheatre> list1 = new ArrayList<MovieTheatre>();
		Scanner sc=new Scanner(System.in);
		System.out.println("### Update Theatre Details ###");
		System.out.println("Enter Movie_Theatre Id:");
		int movieTheatreId=sc.nextInt();
		System.out.println("Enter Movie Timing:");
		String movieTiming=sc.next();
		impl.updateMovieTheatre(movieTheatreId,movieTiming);
		sc.close();
		}
		
		
		private static void testDelete() throws DbException {
			
			Scanner sc=new Scanner(System.in);
			MovieTheatreDAOImpl impl= new MovieTheatreDAOImpl();
			System.out.println("### Delete Theatre Details ###");
			System.out.println("Enter Movie_Theatre Id:");
			int movieTheatreId=sc.nextInt();
			impl.deleteMovieTheatre(movieTheatreId);
			sc.close();
			
		}
		 
                                                                              //To find movie with theatre details	
		private static void testGetTheatreDetails() throws DbException {
          
			MovieTheatreDAOImpl impl= new MovieTheatreDAOImpl();
		   List<MovieTheatre> list = new ArrayList<MovieTheatre>();
		   Scanner sc=new Scanner(System.in);
		   System.out.println("### List Theatre Details ###");
			System.out.println("Enter Movie Id:");
			int movieId=sc.nextInt();
		  list= impl.getTheatreDetails(movieId);
		  for(MovieTheatre movie:list)
		  {
			  System.out.println(movie);
		  }
		  sc.close();
		}
		
		private static void testUpdateMoviePrice() throws DbException {
			
	           MovieTheatreDAOImpl impl= new MovieTheatreDAOImpl();
			   List<MovieTheatre> list1 = new ArrayList<MovieTheatre>();
			   Scanner sc=new Scanner(System.in);
			   System.out.println("### Update Price Details ###");
				System.out.println("Enter Movie_Theatre Id:");
				int movieTheatreId=sc.nextInt();
				System.out.println("Enter Movie_Price:");
				int price=sc.nextInt();
			   impl.updateMoviePrice(price,movieTheatreId);
			   sc.close();
		}
 
		                                                                //To find show Time
		
	private static void testMovieTiming() throws DbException
	{
		MovieTheatreDAOImpl impl= new MovieTheatreDAOImpl();
		List<MovieTheatre> list = new ArrayList<MovieTheatre>();
		
		TheatreList tl=new TheatreList();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Theatre Name:");
	    tl.setTheatreName(sc.nextLine());
		list=impl.getMovieTiming(tl.getTheatreName());
	    for(MovieTheatre theatre:list)
		{
		System.out.println("MovieId:"+theatre.getMovieId()+"-"+"MovieTiming:"+theatre.getMovieTiming());
		
		}
	    sc.close();
	}
	
	private static void testUpdateMovieStatus() throws DbException {
		
        MovieTheatreDAOImpl impl= new MovieTheatreDAOImpl();
		   Scanner sc=new Scanner(System.in);
		   System.out.println("### Update Movie Status ###");
			System.out.println("Enter Movie_Theatre Id:");
			int movieTheatreId=sc.nextInt();
			System.out.println("Enter Movie_Status(0/1):");
			int active=sc.nextInt();
		   impl.updateMovieStatus(active,movieTheatreId);
		   sc.close();
	}
	
	private static void testActiveTheatre() throws DbException {
           MovieTheatreDAOImpl impl= new MovieTheatreDAOImpl();
   		List<MovieTheatre> list = new ArrayList<MovieTheatre>();

           list=impl.getActiveTheatreDetails(999);
   	    for(MovieTheatre theatre:list)
   		{
   		System.out.println(theatre);
   		
   		}
			
        

	}


}
