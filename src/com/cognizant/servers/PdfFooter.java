package com.cognizant.servers;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfFooter extends PdfPageEventHelper  {
	
	Font ffont = new Font(Font.FontFamily.UNDEFINED, 18, Font.BOLDITALIC);
	public   void onEndPage(PdfWriter writer, Document document) {
        PdfContentByte cb = writer.getDirectContent();
        Phrase header = new Phrase("Detailed Report", ffont);
        Phrase footer = new Phrase("Copyright © AcadGild. 2016. All Rights Reserved", ffont);
        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                header(),
                (document.right() - document.left()) / 2 + document.leftMargin(),
                document.top() + 10, 0);
        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                footer(),
                (document.right() - document.left()) / 2 + document.leftMargin(),
                document.bottom() - 10, 0);
        
        //Add the Header Image
        try {
            Image img = Image.getInstance("C:/Users/sumitranchi003/Desktop/AcadGild.png");
            img.setAbsolutePosition(0, PageSize.A4.getHeight() - img.getScaledHeight());
            img.getTop(-60);
            //img.getBottom(-60);
            img.scaleToFit(100,100);
            document.add(img);
          } catch (Exception x) {
            x.printStackTrace();
          }
        
        
    }

	
	private Phrase footer() {
	    Font ffont = new Font(Font.FontFamily.UNDEFINED, 7, Font.BOLDITALIC);
	    Phrase p = new Phrase("Copyright © AcadGild. 2016. All Rights Reserved", ffont);
	    return p;
	}
	
	private Phrase header() {
	    Font ffont = new Font(Font.FontFamily.UNDEFINED, 18, Font.BOLD);
	    Phrase p = new Phrase("Detailed Report", ffont);
	    return p;
	}
}
