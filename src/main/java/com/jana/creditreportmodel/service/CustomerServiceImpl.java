package com.jana.creditreportmodel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jana.creditreportmodel.dao.CustomerDao;
import com.jana.creditreportmodel.entity.CustomersEntity;
import com.jana.creditreportmodel.exceptions.CustomerNotFoundException;
import com.jana.creditreportmodel.exceptions.CustomerRecordNotCreatedException;



@Service
public class CustomerServiceImpl implements CustomerService {
     
	@Autowired
	 private CustomerDao customerDao;
	 
	@Override
	public List<CustomersEntity> findAll() {
		Iterable<CustomersEntity> customers = customerDao.findAll();
		List<CustomersEntity> customersList=new ArrayList<CustomersEntity>();
		customers.forEach(customersList::add);
		return customersList;
	}

	@Override
	public CustomersEntity findById(Long id) {
		
		 Optional<CustomersEntity> customerOptional = customerDao.findById(id);
		 
		 if(customerOptional.isPresent())
			 return customerOptional.get();
		 
		 throw new CustomerNotFoundException(id);
	}

	@Override
	public CustomersEntity save(CustomersEntity customerEntity) {
		
			customerDao.save(customerEntity);
		  Optional<CustomersEntity> customerOptional = customerDao.
				  findById(customerEntity.getCustomerNumber());
		     
		  if(customerOptional.isPresent())
				 return customerOptional.get();
			 
			 throw new CustomerRecordNotCreatedException(customerEntity.getCustomerNumber(),customerEntity.getCustomerName());
	
		
	}

	@Override
	public CustomersEntity update(CustomersEntity customerEntity) {
	
			customerDao.save(customerEntity);
			Optional<CustomersEntity> customerOptional = customerDao.
					  findById(customerEntity.getCustomerNumber());
			if(customerOptional.isPresent())
				return customerOptional.get();
			throw new CustomerNotFoundException(customerEntity.getCustomerNumber());

	}

}
