package com.terasoftware.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	public Connection mysqlConnection(){
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fibercall","root","root");
//			con = DriverManager.getConnection("jdbc:mysql://172.16.0.76:3306/fibercall","tera","tera!23");
			} catch (SQLException e) {
			e.printStackTrace();
		} 
		 return con;
	}

}
