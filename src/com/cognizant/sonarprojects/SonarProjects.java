package com.cognizant.sonarprojects;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cognizant.db.ConnectionManager;

public class SonarProjects {

	private static Connection con = null;
	private  static Statement stmt = null;
	private  static ResultSet rs = null;
	
	public static void main(String[] args) {

		con=ConnectionManager.getConnection();
		
		try {
			stmt=con.createStatement();
			//String var="PRJ";
			rs=stmt.executeQuery("select name,project_uuid from projects where projects.scope = 'PRJ' ");
			while(rs.next()){
				System.out.println("***************************");
				
				System.out.println("Project name is:"+rs.getString(1));
				System.out.println("Project_Uuid is:"+rs.getString(2));
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
