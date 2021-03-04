package com.jana.creditreportmodel.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.CustomRepositoryImplementationDetector;
import org.springframework.stereotype.Service;

import com.jana.creditreportmodel.dao.CustomerDao;
import com.jana.creditreportmodel.entity.CustomersEntity;
import com.jana.creditreportmodel.exceptions.CustomerNotFoundException;
import com.jana.creditreportmodel.exceptions.CustomerNumberAlreadyExistsException;
import com.jana.creditreportmodel.exceptions.CustomerNumberIsEmptyException;
import com.jana.creditreportmodel.exceptions.CustomerRecordNotCreatedException;



@Service
public class CustomerServiceImpl implements CustomerService {
     
	@Autowired
	 private CustomerDao customerDao;
	 
	@Override
	public List<CustomersEntity> findAll() {
		
		Comparator<CustomersEntity> sortBycustomerNumber=Comparator.
				comparing(CustomersEntity::getCustomerNumber);
		
		Iterable<CustomersEntity> customers = customerDao.findAll();
		List<CustomersEntity> customersList=new ArrayList<CustomersEntity>();
		customers.forEach(customersList::add);
		Collections.sort(customersList, sortBycustomerNumber);
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
		  
		  if(customerEntity.getCustomerNumber()==null) {
			  throw new CustomerNumberIsEmptyException(customerEntity.getCustomerName());
		  }
		  
		  if(customerDao.findById(customerEntity.getCustomerNumber()).isPresent()) {
			  throw new CustomerNumberAlreadyExistsException(customerEntity.getCustomerNumber(), 
					  customerEntity.getCustomerName());
		  }
		  
		
		  customerDao.save(customerEntity);
		  Optional<CustomersEntity> customerOptional = customerDao.
				  findById(customerEntity.getCustomerNumber());
		     
		  if(customerOptional.isPresent())
				 return customerOptional.get();
			 
			 throw new CustomerRecordNotCreatedException(customerEntity.getCustomerNumber(),customerEntity.getCustomerName());
	
		
	}

	@Override
	public CustomersEntity update(CustomersEntity customerEntity) {
		
		  if(customerEntity.getCustomerNumber()==null) {
			  throw new CustomerNumberIsEmptyException(customerEntity.getCustomerName());
		  }
		  
		  if(!customerDao.findById(customerEntity.getCustomerNumber()).isPresent()) {
			  throw new CustomerNotFoundException(customerEntity.getCustomerNumber());
		  }
		  
			customerDao.save(customerEntity);
			Optional<CustomersEntity> customerOptional = customerDao.
					  findById(customerEntity.getCustomerNumber());
			if(customerOptional.isPresent())
				return customerOptional.get();
			throw new CustomerNotFoundException(customerEntity.getCustomerNumber());

	}

}
