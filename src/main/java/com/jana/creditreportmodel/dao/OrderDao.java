package com.jana.creditreportmodel.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jana.creditreportmodel.entity.OrdersEntity;



@Repository
public interface OrderDao extends CrudRepository<OrdersEntity,Long> {
	
	//public Iterable<OrdersEntity>  findByCustomerNumber(Long customerNumber);

}
