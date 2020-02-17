package com.movieapp.dao;

import com.movieapp.DbException;
import com.movieapp.model.UserInformation;

public interface UserInformationDAO {
	
	void addUserInformation(UserInformation users) throws DbException;
	void deleteUserInformation(int userId) throws DbException;
	Integer login(String emailId, String epassword) throws DbException;
	boolean updatePassword(String emailId,String epassword) throws DbException;
	String getEmailId(int userId) throws DbException;

}
