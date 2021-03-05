package com.jana.creditreportmodel.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jana.creditreportmodel.constants.ReportCommonConstants;
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
	public byte[] generateReportForAll(final LocalDate generateDate) {
		
	
		   
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
       
       	 List<CustomersEntity> allCustomers = customerService.findAll();
		
     	
	  	allCustomers.forEach(customersEntity-> {
	  		
			byte[] bytes = generateReportForCustomer(customersEntity,generateDate);
			
			ZipEntry zipEntry = new ZipEntry(customersEntity.getCustomerName()+
					ReportCommonConstants.PDF_EXTENSION);	
			 zipEntry.setSize(bytes.length);
			 try {
				zipOutputStream.putNextEntry(zipEntry);
				 zipOutputStream.write(bytes);

			} catch (IOException e) {
				e.printStackTrace();
			}
			
	  	});
	  		
	  	try {
	  		zipOutputStream.closeEntry();
			zipOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	  	 return byteArrayOutputStream.toByteArray();
		
	}
	@Override
	public byte[] generateReportForCustomer(Long customerId, LocalDate generateDate)  {
		
		
		    CustomersEntity customer = customerService.findById(customerId);
		
			 byte[] bytes = generateReportForCustomer(customer,generateDate);
			return bytes;
		
	}

	public  byte[] generateReportForCustomer(CustomersEntity customersEntity, LocalDate generateDate) {
		sortByDate(customersEntity.getOrdersEntityList());
		ReportUtils.performIntrestCalculation(customersEntity.getOrdersEntityList(),generateDate);
		updateTotalAmount(customersEntity.getOrdersEntityList());
	     byte[] bytes = reportGenerator.generatePdfReport(customersEntity,generateDate);
	    return bytes;
	}

	
	private void updateTotalAmount(List<OrdersEntity> ordersEntity) {
		ordersEntity.forEach(order->order.setTotalAmount(order.getCreditInterest()+order.getBillAmount()));
	}

	
	private void sortByDate(List<OrdersEntity> ordersEntity) {
		
		Collections.sort(ordersEntity,sortByBillDate);
	}

	

	
		
		
	



	
}
