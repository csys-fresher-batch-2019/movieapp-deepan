package com.movieapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

public class DbConnection {
	
	public static Connection getConnection(){
		Connection connection=null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		connection=DriverManager.getConnection(url,"system","oracle");
		}catch(ClassNotFoundException e) {
		throw new RuntimeException("Driver class not found");

		}catch(SQLException e)
		{
		throw new RuntimeException("invalid DB credentials"+e.getMessage());

		}

		return connection;
		}
	
	
	public static Jdbi getJdbi() {
		Jdbi jdbi=null;
		Connection connection;
		try {
			connection=getConnection();
			 jdbi = Jdbi.create(connection);
			jdbi.installPlugin(new SqlObjectPlugin());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return jdbi;
	}
}
