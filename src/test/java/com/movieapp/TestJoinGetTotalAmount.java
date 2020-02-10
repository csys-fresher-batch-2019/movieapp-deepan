package com.movieapp;

import java.util.ArrayList;
import java.util.List;

import com.movieapp.dao.impl.JoinGetTotAmtDAOImpl;
import com.movieapp.model.JoinGetTotalAmount;

public class TestJoinGetTotalAmount {

	public static void main(String[] args) throws DbException {
	
		testGetTotalAmount();
	}
	private static void testGetTotalAmount() throws DbException
	{
		JoinGetTotAmtDAOImpl impl=new JoinGetTotAmtDAOImpl();
		List<JoinGetTotalAmount> list=new ArrayList<JoinGetTotalAmount>();
        list=impl.getTotalAmount();
		System.out.println("");
		for(JoinGetTotalAmount amount:list)
		{
		System.out.println(amount);
		
		}
	}
}
