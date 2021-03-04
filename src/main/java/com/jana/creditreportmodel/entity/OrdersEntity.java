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
	
	
	@ManyToOne
	@JoinColumn(name="paymentMethodId")
	private PaymentMethod paymentMethod;
    
	@ManyToOne
	@JoinColumn(name="transStatusId")
	private TransactionStatus transactionStatus;

	private Long billAmount;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CustomerNumber")
	@NotNull
	@JsonIgnore
	private CustomersEntity customersEntity;
	
	
	@Transient
	@JsonIgnore
	private Long creditInterest;
	
	@Transient
	@JsonIgnore
	private Long totalAmount;
	
}
