package com.jana.creditreportmodel.report.pdf;

import java.time.LocalDate;

import com.jana.creditreportmodel.entity.CustomersEntity;

public interface ReportGenerator {
	
	
	public byte[] generatePdfReport(CustomersEntity customersEntity, 
			LocalDate generateDate);

}
