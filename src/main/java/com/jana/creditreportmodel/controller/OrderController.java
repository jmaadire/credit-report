package com.jana.creditreportmodel.controller;

import java.util.List;
import java.util.Optional;

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
import com.jana.creditreportmodel.exceptions.OrderNotFoundException;
import com.jana.creditreportmodel.service.CustomerService;
import com.jana.creditreportmodel.service.OrderService;

@RestController
public class OrderController {
	

@Autowired
OrderService orderService;

@Autowired
CustomerService customerService;


@GetMapping("/orders")
public List<OrdersEntity> findAllOrders() {
	return orderService.findAll();
}

@GetMapping("/orders/{orderId}")
public ResponseEntity<OrdersEntity> getOrdersByOrderId(@PathVariable Long orderId) {
	
	
	      OrdersEntity order = orderService.findById(orderId);
	
        return ResponseEntity.ok().body(order);
   
	
}



@GetMapping("/customers/{customerId}/orders")
public ResponseEntity<List<OrdersEntity>> getOrdersByCustomerId(@PathVariable Long customerId) {
	
	     CustomersEntity customer = customerService.findById(customerId);
	
        return ResponseEntity.ok().body(customer.getOrdersEntityList());

	
}

@GetMapping("/customers/{customerId}/orders/{orderId}")
public ResponseEntity<OrdersEntity> getOrdersByCustomerId(@PathVariable Long customerId,
		  @PathVariable Long orderId) {
	
	    CustomersEntity customer = customerService.findById(customerId);
	    
	    Optional<OrdersEntity> orderOptional = customer.getOrdersEntityList().stream()
	    		   .filter(predicate->predicate.getOrderId().equals(orderId)).findFirst();
	     if(!orderOptional.isPresent())
	    	   throw new OrderNotFoundException(orderId);
        return ResponseEntity.ok().body(orderOptional.get());
	
}

 
@PostMapping("/customers/{customerId}/orders") 
public ResponseEntity<OrdersEntity> saveOrder(@PathVariable(value="customerId") Long customerId,
		@RequestBody OrdersEntity orderEntity) {
	    CustomersEntity customer = customerService.findById(customerId);
	    orderEntity.setCustomersEntity(customer);
	   
	     OrdersEntity createdOrderEntity = orderService.save(orderEntity);
	     
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrderEntity);
    

}

@PutMapping("/customers/{customerId}/orders") 
public ResponseEntity<OrdersEntity> updateOrder(@PathVariable(value="customerId") Long customerId,
		@RequestBody OrdersEntity orderEntity) {
	 
	     CustomersEntity customer = customerService.findById(customerId); 
	  
	     OrdersEntity updatedOrderEntity = orderService.update(orderEntity,customer);
        return ResponseEntity.accepted().body(updatedOrderEntity);
   
}





}