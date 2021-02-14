package com.jana.creditreportmodel.service;

import java.time.LocalDate;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.jana.creditreportmodel.entity.CustomersEntity;

@Service
public class MailSenderServiceImpl implements MailSenderService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
    GenerateReportService generateReportService;
	
	@Autowired
	CustomerService customerService;
    
	@Override
	public void sendMailForCustomer(Long customerId, LocalDate generateDate, String toMail) {
		 MimeMessage message = javaMailSender.createMimeMessage();
		 
		   CustomersEntity customerEntity = customerService.findById(customerId);
		 
		 byte[] bytes = generateReportService.generateReportForCustomer(customerEntity, generateDate);
         try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(toMail);
	        helper.setText("<html><body><h5>please find attachement</h5><body></html>", true);
	        helper.addAttachment(customerEntity.getCustomerName()+"_creditReport", new ByteArrayResource(bytes), "application/zip");
	        helper.setSubject("report Generated");
	        javaMailSender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void sendMailForAllCustomers(LocalDate generateDate, String toMail) {
      
		 byte[] bytes = generateReportService.generateReportForAll(generateDate);
		 
		 MimeMessage message = javaMailSender.createMimeMessage();
		
		 DataSource source = new ByteArrayDataSource(bytes, "application/zip");
		 
         try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(toMail);
	        helper.setText("<html><body><h5>please find attachement</h5><body></html>", true);
	        helper.addAttachment("AllcustomersReports.zip", new ByteArrayResource(bytes));
	        
	        helper.setSubject("report Generation");
	        javaMailSender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
