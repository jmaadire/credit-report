package com.jana.creditreportmodel.utils;

import java.time.LocalDate;

public class CommonUtils {
	
	public static LocalDate converttoLocalDate(String generateDate) {
		LocalDate date=null;
	     if(generateDate==null)
		    date=LocalDate.now();
	     else
	    	date=LocalDate.parse(generateDate);
		return date;
	}
	
	
	public static LocalDate GetToday() {
		return LocalDate.now();
	}
	

}
