package com.cognizant.servers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.db.ConnectionManager;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Header;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Table;

/**
 * Servlet implementation class PdfReport
 */
//@WebServlet("/PdfReport")
public class PdfReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Connection con = null;
	private  static Statement stmt = null;
	private  static ResultSet rs = null;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PdfReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// Step 01:Use the Jdbc steps in connecting through the database
			con=ConnectionManager.getConnection();

			stmt=con.createStatement();
			//String var="PRJ";
			rs=stmt.executeQuery("select issues.id,projects.path,issues.severity,issues.message,issues.line from issues INNER JOIN projects WHERE projects.scope = 'FIL' and projects.project_uuid  = 'AVc8haACGJ03WgFYGwXd' ORDER by projects.path ASC ");

			//Step 02: Initialize PDF documents - logical objects

			Document myPdfReport=new Document(PageSize.A4);
			//Table table=new Table(15);
	        //table.setWidth(myPdfReport.getPageSize().getWidth() - 80);

			
			PdfWriter writer=PdfWriter.getInstance(myPdfReport, new FileOutputStream("E:/Case Study_Trip Plan/AcadGildReport_100.pdf"));//C:\cognizant
			myPdfReport.setMargins(50, 45, 50, 60);
			myPdfReport.setMarginMirroring(false);

			writer.setPageEvent(new PdfFooter());
				

			myPdfReport.open();
			//String url = "https://media.licdn.com/mpr/mpr/shrink_200_200/p/7/000/1f5/0b3/20108b4.png";
			//String x="C:/Users/sumitranchi003/Desktop/speredian.png";
			//Image image = Image.getInstance(x);
			//image.setAbsolutePosition(500f, 650f);
			//image. scaleToFit(133, 72);
			//image.setAbsolutePosition(0, PageSize.A4.getHeight() - image.getScaledHeight());

			//image.getTop(-60);
			//image.getRight(50);
          //  myPdfReport.add(image);


			//writer.setPageEvent(new PdfImageHeader());
			PdfContentByte cb = writer.getDirectContent();

			// Step 03: we have four columns in our table
			PdfPTable my_report_table = new PdfPTable(05);
			// header row:
			/*int n=100000;
            for(int i=0;i<n;i++){
            	my_report_table.addCell("SerialNo");
            }*/

			my_report_table.addCell("SerialNo");
			my_report_table.addCell("File Path");
			my_report_table.addCell("Severity");
			my_report_table.addCell("Error Message");
			my_report_table.addCell("Error Line No");
			my_report_table.setHeaderRows(1);
			my_report_table.setWidthPercentage(100);
			my_report_table.getDefaultCell().setUseAscender(true);
			my_report_table.getDefaultCell().setUseDescender(true);
			/*Font f = new Font(FontFamily.HELVETICA, 13, Font.NORMAL, GrayColor.GRAYWHITE);
            my_report_table.setHorizontalAlignment(Element.ALIGN_JUSTIFIED_ALL);
            my_report_table.setTotalWidth(650);
            my_report_table.setLockedWidth(true);*/
			//Step 04: create a cell object
			PdfPCell table_cell;
			//code to generate the serial number programatically
			// int count=1;

			//Step05: query the resultant parameters using ResultSet
			while (rs.next()) {

				//count++;
				String id = rs.getString("id");
				table_cell=new PdfPCell(new Phrase(id));
				//table_cell.setBackgroundColor(GrayColor.GRAYBLACK);
				table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				//my_report_table.addCell(table_cell,count);
				my_report_table.addCell(table_cell);
				my_report_table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));




				String path = rs.getString("path");
				table_cell=new PdfPCell(new Phrase(path));
				//table_cell.setBackgroundColor(GrayColor.GRAYBLACK);
				table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				//my_report_table.addCell(table_cell,count);
				my_report_table.addCell(table_cell);
				my_report_table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));

				String severity  = rs.getString("severity");
				table_cell=new PdfPCell(new Phrase(severity));
				//table_cell.setBackgroundColor(GrayColor.GRAYBLACK);
				table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				my_report_table.addCell(table_cell);
				my_report_table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));


				String message  = rs.getString("message");
				table_cell=new PdfPCell(new Phrase(message));
				//table_cell.setBackgroundColor(GrayColor.GRAYBLACK);
				table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				my_report_table.addCell(table_cell);
				my_report_table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));


				String line  = rs.getString("line");
				table_cell=new PdfPCell(new Phrase(line));
				//table_cell.setBackgroundColor(GrayColor.GRAYBLACK);
				table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				my_report_table.addCell(table_cell);
				my_report_table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));


			}

			//Step06:

			/* Attach report table to PDF */
			myPdfReport.add(my_report_table);                       
			myPdfReport.close();




			System.out.println("Successfully!!!! Generated the PDF Report!!!!!!!!!");


		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {

				rs.close();
				con.close();
				stmt.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
