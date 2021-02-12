package com.jana.creditreportmodel.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jana.creditreportmodel.entity.CustomersEntity;
import com.jana.creditreportmodel.entity.OrdersEntity;
import com.jana.creditreportmodel.service.CustomerService;

@RestController
public class CustomerController {
	

@Autowired
CustomerService customerService;



@GetMapping("/customers")
public List<CustomersEntity> findAllCustomers() {
	return customerService.findAll();
}



@GetMapping("/customers/{id}")
public ResponseEntity<CustomersEntity> getCustomerById(@PathVariable(value="id") Long id) {
	
	    CustomersEntity customer = customerService.findById(id);
	       
        return ResponseEntity.ok().body(customer);
        
    
	
}

@PostMapping("/customers") 
public ResponseEntity<CustomersEntity> SaveCustomer(@RequestBody CustomersEntity customerEntity) {
	
	      CustomersEntity customer = customerService.save(customerEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(customer);

}

@PutMapping("/customers") 
public ResponseEntity<CustomersEntity> updateCustomer(@RequestBody CustomersEntity ce) {
	
	   CustomersEntity customer = customerService.update(ce);
      return ResponseEntity.accepted().body(customer);
  
}



@GetMapping("updateBasicDetails")
public String updateBasicDetails() {

	
	CustomersEntity customersEntity=new CustomersEntity();
     //customersEntity.setCustomerNumber(1l);
	 customersEntity.setCustomerName("Jana");
	 customersEntity.setPhoneNumber(9989057975l);
	 customersEntity.setAlternatePhoneNumber(7010354849l);
	 customersEntity.setEmailId("janardhanr728@gmail.com");
	 customersEntity.setDateOfBirth(LocalDate.of(1995, 10, 06));
	 
	 OrdersEntity o4 = new OrdersEntity();
     o4.setBillDate(LocalDate.of(2019, 02, 10));
     o4.setBillNumber("14");
     o4.setBillAmount(4000l);
     o4.setIsCredit(false);
     OrdersEntity o3 = new OrdersEntity();
     o3.setBillDate(LocalDate.of(2020,10,10));
     o3.setBillNumber("15");
     o3.setBillAmount(2000l);
     o3.setIsCredit(false);
     OrdersEntity o2 = new OrdersEntity();
     o2.setBillDate(LocalDate.of(2019,12,10));
     o2.setBillNumber("13");
     o2.setBillAmount(5000l);
     o2.setIsCredit(true);
     OrdersEntity o1 = new OrdersEntity();
     o1.setBillDate(LocalDate.of(2020,02,10));
     o1.setBillNumber("12");
     o1.setBillAmount(6000l);
     o1.setIsCredit(true);
	List<OrdersEntity> list=new ArrayList<OrdersEntity>();
	list.add(o1);
	list.add(o2);
	list.add(o3);
	list.add(o4);
	list.forEach(action->action.setCustomersEntity(customersEntity));
	customersEntity.setOrdersEntityList(list);
	
	  
	
	 customerService.save(customersEntity);
	
	return "success";
}

}