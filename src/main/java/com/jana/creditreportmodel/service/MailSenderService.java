package com.jana.creditreportmodel.service;

import java.time.LocalDate;

public interface MailSenderService {
	

	  public void sendMailForCustomer(Long customerId,LocalDate generateDate,
			  String toMail);

	  public void sendMailForAllCustomers(LocalDate generateDate,String toMail);

}
