package com.jana.creditreportmodel.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jana.creditreportmodel.entity.TransactionStatus;



@Repository
public interface TransactionStatusDao extends CrudRepository<TransactionStatus,Integer> {

}
