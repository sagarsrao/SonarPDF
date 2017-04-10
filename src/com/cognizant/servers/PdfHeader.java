package com.cognizant.servers;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfHeader  extends PdfPageEventHelper{ 
	
	public void onEndPage(PdfWriter writer, Document document) {
		try {
			Image header = Image.getInstance("/Images/Ctz.png");
		    //header.setAbsolutePosition(792, 0);
		    //header.scaleAbsolute(595, 50)
		    //header.scaleAbsolute(595, 50);
		    writer.getDirectContent().addImage(header);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    
	}

}
