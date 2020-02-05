package com.movieapp.dao;

import com.movieapp.model.UserInformation;

public interface UserInformationDAO {
	
	void addUserInformation(UserInformation users) throws Exception;
	void deleteUserInformation(int userId) throws Exception;
	String login(String emailId, String epassword) throws Exception;
	String updatePassword(String emailId,String epassword) throws Exception;
	

}
