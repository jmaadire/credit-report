package com.jana.creditreportmodel.service;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;

import com.jana.creditreportmodel.entity.CustomersEntity;

public interface GenerateReportService {

	public ByteArrayInputStream generateReportForCustomer(Long customerId, LocalDate generateDate);
	
	
	public void generateReportForAll(LocalDate generateDate);


	public ByteArrayInputStream generateReportForCustomer(CustomersEntity customer, LocalDate date);
	
}
