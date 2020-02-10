package com.movieapp.dao;

import java.util.List;

import com.movieapp.DbException;
import com.movieapp.model.JoinGetTotalAmount;

public interface JoinGetTotAmtDAO {

	public List <JoinGetTotalAmount> getTotalAmount() throws DbException;
}
