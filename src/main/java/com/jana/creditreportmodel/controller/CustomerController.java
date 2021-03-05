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



@GetMapping("/updateBasicDetails")
public String updateBasicDetails() {

	
	CustomersEntity customersEntity1=new CustomersEntity();
	CustomersEntity customersEntity2=new CustomersEntity();
	 customersEntity1.setCustomerNumber(1l);
	 customersEntity1.setCustomerName("Jana");
	 customersEntity1.setPhoneNumber(9989057975l);
	 customersEntity1.setAlternatePhoneNumber(7010354849l);
	 customersEntity1.setEmailId("raghavmalgari@gmail.com");
	 customersEntity1.setDateOfBirth(LocalDate.of(1995, 10, 06));
		
	 customersEntity2.setCustomerNumber(2l);
	 customersEntity2.setCustomerName("raghu");
	 customersEntity2.setPhoneNumber(9493809451l);
	 customersEntity2.setAlternatePhoneNumber(7010354849l);
	 customersEntity2.setEmailId("raghavmalgari@gmail.com");
	 customersEntity2.setDateOfBirth(LocalDate.of(1995, 10, 06));
	 
	 
	 OrdersEntity o4 = new OrdersEntity();
     o4.setBillDate(LocalDate.of(2019, 02, 10));
     o4.setBillNumber("14");
     o4.setBillAmount(4000l);
     OrdersEntity o3 = new OrdersEntity();
     o3.setBillDate(LocalDate.of(2020,10,10));
     o3.setBillNumber("15");
     o3.setBillAmount(2000l);
     OrdersEntity o2 = new OrdersEntity();
     o2.setBillDate(LocalDate.of(2019,12,10));
     o2.setBillNumber("13");
     o2.setBillAmount(5000l);
     OrdersEntity o1 = new OrdersEntity();
     o1.setBillDate(LocalDate.of(2020,02,10));
     o1.setBillNumber("12");
     o1.setBillAmount(6000l);
	List<OrdersEntity> list=new ArrayList<OrdersEntity>();
	list.add(o1);
	list.add(o2);
	
	list.forEach(action->action.setCustomersEntity(customersEntity1));
	customersEntity1.setOrdersEntityList(list);
	
	List<OrdersEntity> list1=new ArrayList<OrdersEntity>();

	list1.add(o3);
	list1.add(o4);
	list1.forEach(action->action.setCustomersEntity(customersEntity2));
	
	customersEntity2.setOrdersEntityList(list1);
	
	  
	
	 customerService.save(customersEntity1);
	 customerService.save(customersEntity2);
	
	return "success";
}

}