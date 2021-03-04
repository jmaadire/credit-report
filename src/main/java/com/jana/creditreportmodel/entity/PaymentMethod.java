package com.jana.creditreportmodel.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="paymentMethod")
public class PaymentMethod implements Serializable,Comparable<PaymentMethod> {
	
   
	
     /**
	 * 
	 */
	private static final long serialVersionUID = 5612511939994158035L;

  @Id
  @GeneratedValue
  private Integer  paymentMethodId;
  
  private String paymentMethodStatus;

@Override
public int compareTo(PaymentMethod pay) {
	return paymentMethodId.compareTo(pay.getPaymentMethodId());
}
   
}
