package com.movieapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.movieapp.DbConnection;
import com.movieapp.dao.UserInformationDAO;
import com.movieapp.model.UserInformation;

public class UserInformationImpl implements UserInformationDAO{

		public void addUserInformation(UserInformation users) throws Exception {
			// TODO Auto-generated method stub
			Connection con=DbConnection.getConnection();
			String sql="insert into users(user_id,user_name,email_id,epassword,mobile_num,gender)values(user_id_seq.nextval,?,?,?,?,?)";
			//System.out.println(sql);
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,users.getUserName());
			pst.setString(2,users.getEmailId());
			pst.setString(3,users.getEpassword());
			pst.setLong(4,users.getMobileNum());
			pst.setString(5, users.getGender());
			int row=pst. executeUpdate();
			System.out.println(row);

			
		}

		public void deleteUserInformation(int userId) throws Exception {
			// TODO Auto-generated method stub
			Connection con=DbConnection.getConnection();
			String sql="delete from users where user_id=?";
			//System.out.println(sql);
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1,userId);
			int row=pst. executeUpdate();
			System.out.println(row);
			
		}
		
		
		public String login(String emailId, String epassword) throws Exception {
			// TODO Auto-generated method stub

			Connection con=DbConnection.getConnection();
            String sql = "select email_id,epassword from users where email_id= '" + emailId + "' and epassword = '"+ epassword + "'";
			//System.out.println(sql);
			String s=null;
			ResultSet row = con.createStatement().executeQuery(sql);
			if (row.next())
			{
				String emailid1 = row.getString("email_id");
				String password1 = row.getString("epassword");
				if (emailid1.equals(emailId) && password1.equals(epassword))
					s="success";
				
		}
			else
				s="failure";
			
			return(s);
		}
		public String updatePassword(String emailId,String epassword) throws Exception
		{
			Connection con = DbConnection.getConnection();
			String sqlb = "update users set epassword=? where email_id=?";
			System.out.println("");
			//System.out.println(sqlb);
			PreparedStatement pst = con.prepareStatement(sqlb);
			pst.setString(1, epassword);
			pst.setString(2, emailId);
			int rowb = pst.executeUpdate();
			//System.out.println(rowb);
			con.close();
			return epassword;
			
		}

}

