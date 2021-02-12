package com.jana.creditreportmodel.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jana.creditreportmodel.entity.CustomersEntity;



@Repository
public interface CustomerDao extends CrudRepository<CustomersEntity,Long> {

}
