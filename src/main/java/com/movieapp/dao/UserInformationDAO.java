package com.movieapp.dao;

import com.movieapp.DbException;
import com.movieapp.model.UserInformation;

public interface UserInformationDAO {
	
	void addUserInformation(UserInformation users) throws DbException;
	void deleteUserInformation(int userId) throws DbException;
	String login(String emailId, String epassword) throws DbException;
	String updatePassword(String emailId,String epassword) throws DbException;
	

}
