package com.jana.creditreportmodel.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.jana.creditreportmodel.constants.ReportCommonConstants;


public class ReportUtils {
	
	public static long calculateInterest(LocalDate fromDate,LocalDate toDate,Long amount) {
		    
		   long days = getDaysBetweenDates(fromDate, toDate);
    	  
           long interest=(amount*ReportCommonConstants.INTEREST_RATE*days)/(30*100);
           
		return interest;
	}

	public static long getDaysBetweenDates(LocalDate fromDate, LocalDate  toDate) {
		
		long days = ChronoUnit.DAYS.between(fromDate, toDate);

		return days;
	}
}
