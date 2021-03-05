package com.jana.creditreportmodel.initialdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.jana.creditreportmodel.dao.TransactionStatusDao;
import com.jana.creditreportmodel.entity.TransactionStatus;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class TransactionStatusData implements ApplicationListener<ApplicationReadyEvent> {
   
	@Autowired 
	TransactionStatusDao transactionStatusDao;
	
    public void onApplicationEvent(ApplicationReadyEvent event) {
    	
        if (transactionStatusDao.count() > 0) {
            return;
        }
    	
        transactionStatusDao.save(new TransactionStatus(1,"Pending"));
        transactionStatusDao.save(new TransactionStatus(2,"Complete"));
 
    }
}
