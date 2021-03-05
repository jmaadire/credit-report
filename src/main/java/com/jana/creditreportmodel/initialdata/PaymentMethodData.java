package com.jana.creditreportmodel.initialdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.jana.creditreportmodel.dao.PaymentMethodDao;
import com.jana.creditreportmodel.entity.PaymentMethod;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class PaymentMethodData implements ApplicationListener<ApplicationReadyEvent> {
   
	@Autowired 
	PaymentMethodDao paymentMethodDao;
	
    public void onApplicationEvent(ApplicationReadyEvent event) {
    	
        if (paymentMethodDao.count() > 0) {
            return;
        }
    	
    	paymentMethodDao.save(new PaymentMethod(1,"Credit"));
    	paymentMethodDao.save(new PaymentMethod(2,"Cash"));
 
    }
}
