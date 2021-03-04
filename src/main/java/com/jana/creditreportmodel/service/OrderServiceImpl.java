package com.jana.creditreportmodel.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jana.creditreportmodel.dao.OrderDao;
import com.jana.creditreportmodel.entity.CustomersEntity;
import com.jana.creditreportmodel.entity.OrdersEntity;
import com.jana.creditreportmodel.exceptions.InvalidCustomerOfOrderException;
import com.jana.creditreportmodel.exceptions.OrderNotFoundException;
import com.jana.creditreportmodel.exceptions.OrderRecordNotCreatedException;



@Service
public class OrderServiceImpl implements OrderService {
     
	@Autowired
	 private OrderDao orderDao;
	
	Comparator<OrdersEntity> sortByBillDate= (order1,order2)->{
		
		return order1.getBillDate().compareTo(order2.getBillDate());
	};
	
	@Override
	public List<OrdersEntity> findAll() {
		Iterable<OrdersEntity> orders = orderDao.findAll();
		List<OrdersEntity> ordersList=new ArrayList<>();
		orders.forEach(ordersList::add);
		Collections.sort(ordersList,sortByBillDate);
		return ordersList;
	}

	@Override
	public OrdersEntity findById(Long id) {
	
		Optional<OrdersEntity> orderOptional = orderDao.findById(id);
		 
		 if(orderOptional.isPresent())
			 return orderOptional.get();
		 
		 throw new OrderNotFoundException(id);
	}

	@Override
	public OrdersEntity save(OrdersEntity orderEntity) {
			orderDao.save(orderEntity);
		  Optional<OrdersEntity> orderOptional = orderDao.
				  findById(orderEntity.getOrderId());
		     
		  if(orderOptional.isPresent())
				 return orderOptional.get();
			 
			 throw new OrderRecordNotCreatedException(orderEntity.getOrderId(),orderEntity.getBillNumber()
					 ,orderEntity.getBillDate());
		
	}

	@Override
	public OrdersEntity update(OrdersEntity orderEntity,CustomersEntity customerEntity) {
		
		if(orderDao.existsById(orderEntity.getOrderId()))  {
			Long customerNumber=orderEntity.getCustomersEntity().getCustomerNumber();
			
			
		   if(customerNumber ==null || !customerNumber.equals(customerEntity.getCustomerNumber())) 
				   throw new InvalidCustomerOfOrderException(customerNumber,orderEntity.getOrderId());
		   
		    List<OrdersEntity> ordersList = customerEntity.getOrdersEntityList();
		    
		   boolean existsStatus = ordersList.stream().filter(Objects::nonNull)
				   .anyMatch(order->order.getOrderId().equals(orderEntity.getOrderId()));
		   
		    if(!existsStatus)
				   throw new InvalidCustomerOfOrderException(customerNumber,orderEntity.getOrderId());
			
			orderDao.save(orderEntity);
			Optional<OrdersEntity> orderOptional = orderDao.
					  findById(orderEntity.getOrderId());
			if(orderOptional.isPresent())
				return orderOptional.get();
			throw new OrderNotFoundException(orderEntity.getOrderId());
		}
		throw new OrderNotFoundException(orderEntity.getOrderId());
		
	}

	@Override
	public List<OrdersEntity> findByCustomerNumber(Long customerNumber) {
		// TODO Auto-generated method stub
		return null;
	}


}
