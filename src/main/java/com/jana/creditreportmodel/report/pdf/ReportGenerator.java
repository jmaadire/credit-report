package com.jana.creditreportmodel.report.pdf;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;

import com.jana.creditreportmodel.entity.CustomersEntity;

public interface ReportGenerator {
	
	public ByteArrayInputStream generateByteArrayReport(CustomersEntity customersEntity, 
			LocalDate generateDate);
	
	public void generatePdfReport(CustomersEntity customersEntity, 
			LocalDate generateDate);

}
