package com.jana.creditreportmodel.controller;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
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



@RestController
public class ReportGenerationController {
	
	@Autowired
	GenerateReportService generateReportService;
	
	@Autowired
	CustomerService customerService;
	
	

	@GetMapping(value="/customers/{customerId}/report",produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> generateReportById(@PathVariable(value="customerId",required=true) 
	   Long customerId,@RequestParam(required = false) String generateDate) {
		
		     LocalDate date=null;
		     if(generateDate==null)
			    date=LocalDate.now();
		     else
		    	date=LocalDate.parse(generateDate);
		     
			CustomersEntity customer = customerService.findById(customerId);

		    
		     ByteArrayInputStream bytes = generateReportService.
		    		               generateReportForCustomer(customer, date);
		     
		      HttpHeaders headers = new HttpHeaders();
		        headers.add("Content-Disposition", "inline; filename="+customer.getCustomerName()+
		        		ReportCommonConstants.PDF_EXTENSION);

		        return ResponseEntity
		                .ok()
		                .headers(headers)
		                .contentType(MediaType.APPLICATION_PDF)
		                .body(new InputStreamResource(bytes));
		   //  return ResponseEntity.ok().body("Successfully Genereated");
	
		
	}
	
	@GetMapping("/customers/genarateAllReports")
	public ResponseEntity<String> genarateAllReports(
	@RequestParam(required = false) String generateDate) {
		  LocalDate date=null;
	     if(generateDate==null)
		    date=LocalDate.now();
	     else
	    	date=LocalDate.parse(generateDate);
	     
		     generateReportService.generateReportForAll(date);
	        return ResponseEntity.ok().body("successfully generated all the reports");
	}
	
	
}
