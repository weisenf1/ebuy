package com.weisen.ebuy2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://127.0.0.1:3306/ebuy";
	private static final String USER="root";
	private static final String PASSWORD="123456";
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void free(ResultSet rs,Statement st) {
		if(st!=null){
			try {
				st.close();
				st=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rs!=null){
			try {
				rs.close();rs=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
//	public static void main(String[] args) throws Exception {
//		// TODO Auto-generated method stub
//			Class.forName(DRIVER);
//			Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
//			Statement st=conn.createStatement();
//			String sql="select * from voter";
//			ResultSet rs=st.executeQuery(sql);
//			while(rs.next()) {
//				System.out.println(rs.getString(1)+""+rs.getString(2)+""+rs.getInt(3));
//			}
//	}

}

