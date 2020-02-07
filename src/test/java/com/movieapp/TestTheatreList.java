package com.movieapp;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.movieapp.dao.impl.MovieListDAOImpl;
import com.movieapp.dao.impl.MovieTheatreDAOImpl;
import com.movieapp.dao.impl.TheatreListDAOImpl;
import com.movieapp.model.MovieTheatre;
import com.movieapp.model.TheatreList;

public class TestTheatreList {

	public static void main(String[] args) throws Exception {
		
		  //testInsert();
         // testDeleteTheatreDetails();
         // testUpdateTheatreRating();
         //testAllTheatreDetails();
         //testGetTheatreName();

	}
	private static void testInsert() throws Exception
	{
		 List<TheatreList> list=new ArrayList<TheatreList>();

		 TheatreList t1=new TheatreList();

		 t1.setTheatreName("kamala cinemas");
		 t1.setNumberSeats(230);
		 t1.setTheatreAddress("vadapalani chennai");
		 t1.setTheatreRating(4);
		 list.add(t1);

		 TheatreListDAOImpl obj=new TheatreListDAOImpl();

		 for(TheatreList theatreList:list)
		 {
		 obj.addTheatreDetails(theatreList);
		 System.out.println(theatreList);
		 }
	}
	private static void testDeleteTheatreDetails() throws Exception
	{
		TheatreListDAOImpl obj=new TheatreListDAOImpl();
		Scanner sc=new Scanner(System.in);
		System.out.println("### Delete Theatre Details ###");
		System.out.println("Enter Theatre_Id:");
		int theatreId=sc.nextInt();
		obj.deleteTheatreDetails(theatreId);
		sc.close();
		
	}
	private static void testUpdateTheatreRating() throws Exception
	{
		TheatreListDAOImpl obj=new TheatreListDAOImpl();
		Scanner sc=new Scanner(System.in);
		System.out.println("### Update Theatre Rating ###");
		System.out.println("Enter Theatre Name:");
		String theatreName=sc.next();
		System.out.println("Enter Theatre Rating:");
		int theatreRating=sc.nextInt();
		obj.updateTheatreRating(theatreRating,theatreName);
		sc.close();
	}
	
	private static void testAllTheatreDetails() throws Exception
	{
		 List<TheatreList> list=new ArrayList<TheatreList>();
		 TheatreListDAOImpl obj=new TheatreListDAOImpl();

		list=obj.allTheatreDetails();
		for(TheatreList theatreList:list)
		{
		System.out.println(theatreList);
		}
	}
	private static void testGetTheatreName() throws Exception
	{
		 TheatreListDAOImpl obj=new TheatreListDAOImpl();
		 List<TheatreList> list=new ArrayList<TheatreList>();
		 Scanner sc=new Scanner(System.in);
			System.out.println("### Search Theatre Name By Address ###");
			System.out.println("Enter Theatre Address:");
			String theatreAddress=sc.next();
			list=obj.getTheatreName(theatreAddress);
			for(TheatreList theatreList:list)
			{
			System.out.println(theatreList.getTheatreName());
			}
			
         }
	}

