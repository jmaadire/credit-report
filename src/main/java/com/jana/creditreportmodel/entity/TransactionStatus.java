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
@Table(name="transactionStatus")
public class TransactionStatus implements Serializable,Comparable<TransactionStatus> {
	
   /**
	 * 
	 */
	private static final long serialVersionUID = 7020677951419916927L;
	
  @Id
  @GeneratedValue
  private Integer transStatusId;
  
  private String transStatus;

  
@Override
public int compareTo(TransactionStatus paid) {
	return transStatusId.compareTo(paid.getTransStatusId());
}
   

}
