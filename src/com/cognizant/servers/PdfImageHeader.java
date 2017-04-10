package com.cognizant.servers;

import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfImageHeader extends PdfPageEventHelper {
	
	Image image;
	
	  public  void OnOpenDocument(PdfWriter writer, Document document) throws BadElementException, MalformedURLException, IOException {
		  String x="C:/Users/sumitranchi003/Desktop/speredian.png";
			Image image = Image.getInstance(x);
			//image.setAbsolutePosition(500f, 650f);
			//image. scaleToFit(133, 72);
			image.setAbsolutePosition(0, PageSize.A4.getHeight() - image.getScaledHeight());

			image.getTop(-60);
	    }
	  
	  public  void OnEndPage(PdfWriter writer, Document document) throws DocumentException {
		    writer.getDirectContent().addImage(image);
	    }

}
