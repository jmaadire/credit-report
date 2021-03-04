package com.jana.creditreportmodel.service;

import java.util.List;

import com.jana.creditreportmodel.entity.CustomersEntity;
import com.jana.creditreportmodel.entity.OrdersEntity;


public interface OrderService {

 public List<OrdersEntity>  findAll();
 
 public OrdersEntity findById(Long id);
 
 
 public OrdersEntity  save(OrdersEntity order);
 
 public OrdersEntity  update(OrdersEntity order, CustomersEntity customer);
 
 
}
