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
@Table(name="paidStatus")
public class PaidStatus implements Serializable {
	
   /**
	 * 
	 */
	private static final long serialVersionUID = 7020677951419916927L;
	
  @Id
  @GeneratedValue
  private Long  paidStatusId;
  
  private String paidStatus;
   

}
