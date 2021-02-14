package com.jana.creditreportmodel.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

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
@Table(name="customer")
public class CustomersEntity  implements Serializable {

  private static final long serialVersionUID = 262248133006900097L;

  @Id	
  private Long customerNumber;
  
  @NotEmpty
  private String customerName;
  
  private Long phoneNumber;
  
  private Long alternatePhoneNumber;
  
  private String emailId;
  
  private LocalDate DateOfBirth;
  
  private String address;
  
  
  @OneToMany(mappedBy = "customersEntity",
  fetch = FetchType.LAZY,cascade=CascadeType.ALL)
  @JsonIgnore
  private List<OrdersEntity> ordersEntityList;

  
}
