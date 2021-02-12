package com.jana.creditreportmodel.service;

import java.util.List;

import com.jana.creditreportmodel.entity.CustomersEntity;


public interface CustomerService {

 public List<CustomersEntity>  findAll();
 
 public CustomersEntity findById(Long id);
 
 public CustomersEntity  save(CustomersEntity ce);
 
 public CustomersEntity  update(CustomersEntity ce);
 
 
}
