package com.cognizant.servers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.db.ConnectionManager;

/**
 * Servlet implementation class DisplayTable
 */
//@WebServlet("/DisplayTable")
public class DisplayTable extends HttpServlet {
	
	private static Connection con = null;
	private  static Statement stmt = null;
	private  static ResultSet rs = null;
	
	
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DisplayTable() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        out.println("<html><body>");
        try{
        	con=ConnectionManager.getConnection();
        	
        	stmt=con.createStatement();
			//String var="PRJ";
			rs=stmt.executeQuery("select name,project_uuid from projects where projects.scope = 'PRJ' ");
			
			out.println("<table border=1 width=50% height=50%>");
			
            out.println("<tr><th>ProjectName</th><th>ProjectID</th><th>ProjectLink</th><tr>");
        	
            while (rs.next()) {
            	
                String projectname = rs.getString("name");
                String projectid = rs.getString("project_uuid");
                out.println("<tr><td>" + projectname + "</td><td>" + projectid + "</td><td>");
                out.println("<input type=button VALUE="+ "\"Export Data\">  </td>");
            }
            out.println("</table>");
            out.println("</html></body>");
            con.close();

            
        	
        }catch(Exception e){
        	e.printStackTrace();
        }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
