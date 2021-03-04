package com.jana.creditreportmodel.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name="orders")
public class OrdersEntity implements Serializable {
    
	
	private static final long serialVersionUID = -6983381319761816165L;
	
	
	@Id
	@GeneratedValue
	private Long orderId;
	
	private String billNumber;
	
	private LocalDate billDate;
	
	private Long creditInterest;
	
	private Boolean isCredit;
    
	@ManyToOne
	@JoinColumn(name="paidStatusId")
	private PaidStatus paidStatus;

	private Long billAmount;
	
	
	
	@Transient
	private Long totalAmount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CustomerNumber")
	@NotNull
	@JsonIgnore
	private CustomersEntity customersEntity;
	
}
