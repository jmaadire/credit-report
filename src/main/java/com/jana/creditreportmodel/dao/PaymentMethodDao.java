package com.jana.creditreportmodel.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jana.creditreportmodel.entity.PaymentMethod;



@Repository
public interface PaymentMethodDao extends CrudRepository<PaymentMethod,Integer> {

}
