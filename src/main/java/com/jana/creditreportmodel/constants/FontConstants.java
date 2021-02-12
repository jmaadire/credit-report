package com.jana.creditreportmodel.constants;

import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.CMYKColor;

public class FontConstants {
	
	    public final static Font SMALL_BOLD = new Font(Font.FontFamily.TIMES_ROMAN, 8,
	            Font.BOLD);
	    public final static Font MEDIUM_BOLD = new Font(Font.FontFamily.TIMES_ROMAN, 8,
	            Font.BOLD);
	    public final static Font NORMAL_FONT = new Font(Font.FontFamily.TIMES_ROMAN, 8,
	            Font.NORMAL);
	    public final static  Font RED_BOLD_FONT = FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD, 
	    		                    new CMYKColor(0, 255, 0, 0));

	    public final static Font BLUE_BOLD_FONT = FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, new CMYKColor(255, 0, 0, 0));



}
