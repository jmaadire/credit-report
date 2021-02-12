package com.jana.creditreportmodel.service;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jana.creditreportmodel.entity.CustomersEntity;
import com.jana.creditreportmodel.entity.OrdersEntity;
import com.jana.creditreportmodel.report.pdf.ReportGenerator;
import com.jana.creditreportmodel.utils.ReportUtils;

@Service
public class GenerateReportServiceImpl implements GenerateReportService {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	ReportGenerator reportGenerator;
	
	
	Comparator<OrdersEntity> sortByBillDate= (order1,order2)->{
		
		return order1.getBillDate().compareTo(order2.getBillDate());
	};

	@Override
	public void generateReportForAll(final LocalDate generateDate) {
		List<CustomersEntity> allCustomers = customerService.findAll();
		
		allCustomers.forEach(customersEntity-> {
			sortByDate(customersEntity.getOrdersEntityList());
			performIntrestCalculation(customersEntity.getOrdersEntityList(),generateDate);
			updateTotalAmount(customersEntity.getOrdersEntityList());
			reportGenerator.generatePdfReport(customersEntity, generateDate);});
		
	}
	@Override
	public ByteArrayInputStream generateReportForCustomer(Long customerId, LocalDate generateDate)  {
		
		
		    CustomersEntity customer = customerService.findById(customerId);
		
			ByteArrayInputStream bytes = generateReportForCustomer(customer,generateDate);
			return bytes;
		
		
	}

	public ByteArrayInputStream generateReportForCustomer(CustomersEntity customersEntity, LocalDate generateDate) {
		sortByDate(customersEntity.getOrdersEntityList());
		performIntrestCalculation(customersEntity.getOrdersEntityList(),generateDate);
		updateTotalAmount(customersEntity.getOrdersEntityList());
	    ByteArrayInputStream bytes = reportGenerator.generateByteArrayReport(customersEntity,generateDate);
	    return bytes;
	}

	
	private void updateTotalAmount(List<OrdersEntity> ordersEntity) {
		ordersEntity.forEach(order->order.setTotalAmount(order.getCreditInterest()+order.getBillAmount()));
	}

	private void sortByDate(List<OrdersEntity> ordersEntity) {
		
		Collections.sort(ordersEntity,sortByBillDate);
	}

	private void performIntrestCalculation(List<OrdersEntity> ordersEntity, LocalDate generateDate) {
       ordersEntity.forEach(order->{
    	 Long interest=ReportUtils.calculateInterest(order.getBillDate(), generateDate, 
    			 order.getBillAmount());
    	 order.setCreditInterest(interest);
       });
	}

	
		
		
	



	
}
