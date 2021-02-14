package com.jana.creditreportmodel.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jana.creditreportmodel.constants.ReportCommonConstants;
import com.jana.creditreportmodel.entity.CustomersEntity;
import com.jana.creditreportmodel.service.CustomerService;
import com.jana.creditreportmodel.service.GenerateReportService;
import com.jana.creditreportmodel.utils.CommonUtils;



@RestController
public class ReportGenerationController {
	
	@Autowired
	GenerateReportService generateReportService;
	
	@Autowired
	CustomerService customerService;
	
	

	@GetMapping(value="/customers/{customerId}/report",produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<byte[]> generateReportById(@PathVariable(value="customerId",required=true) 
	   Long customerId,@RequestParam(required = false) String generateDate) {
		
		     LocalDate date = CommonUtils.converttoLocalDate(generateDate);
		     
			CustomersEntity customer = customerService.findById(customerId);

		    
		      byte[] bytes = generateReportService.
		    		               generateReportForCustomer(customer, date);
		     
		      HttpHeaders headers = new HttpHeaders();
		        headers.add("Content-Disposition", "inline; filename="+customer.getCustomerName()+
		        		ReportCommonConstants.PDF_EXTENSION);

		        return ResponseEntity
		                .ok()
		                .headers(headers)
		                .contentType(MediaType.APPLICATION_PDF)
		                .body(bytes);
		   //  return ResponseEntity.ok().body("Successfully Genereated");
	
		
	}
	
	@GetMapping("/customers/genarateAllReports")
	public ResponseEntity<byte[]> genarateAllReports(
	@RequestParam(required = false) String generateDate) {
		
		     LocalDate date = CommonUtils.converttoLocalDate(generateDate);
		     
		     byte[] bytes = generateReportService.generateReportForAll(date);
	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Disposition", "inline; filename="+"test"+".zip");

	        return ResponseEntity
	                .ok()
	                .headers(headers)
	                .contentType(MediaType.APPLICATION_OCTET_STREAM)
	                .body(bytes);
	}


	
	
}
