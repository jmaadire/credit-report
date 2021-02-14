package com.jana.creditreportmodel.service;

import java.time.LocalDate;

import com.jana.creditreportmodel.entity.CustomersEntity;

public interface GenerateReportService {

	public byte[] generateReportForCustomer(Long customerId, LocalDate generateDate);
	
	
	public byte[] generateReportForAll(LocalDate generateDate);


	public byte[] generateReportForCustomer(CustomersEntity customer, LocalDate date);
	
}
