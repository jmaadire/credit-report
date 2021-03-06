package com.jana.creditreportmodel.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jana.creditreportmodel.service.MailSenderService;
import com.jana.creditreportmodel.utils.CommonUtils;

@RestController
public class MailSenderController {
	
	@Autowired
	MailSenderService mailSenderService;
	
	@GetMapping("/sendMail/{customerId}")
	public ResponseEntity<String> sendMail(@PathVariable Long customerId,@RequestParam(required =false) String generateDate,
			@RequestParam(required =false) String toMail) {
		
		 LocalDate date = CommonUtils.converttoLocalDate(generateDate);
			
		mailSenderService.sendMailForCustomer(customerId, date, toMail);
		return ResponseEntity.ok().body("successfully sent");		
	}
	
	@GetMapping("/sendMail/allCustomers")
	public ResponseEntity<String> sendMail(@RequestParam(required =false) String generateDate,
			@RequestParam(required =false) String toMail) {
		 LocalDate date = CommonUtils.converttoLocalDate(generateDate);

		mailSenderService.sendMailForAllCustomers(date, toMail);
		
		return ResponseEntity.ok().body("successfully sent");		
		
	}

}
