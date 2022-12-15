package com.boot.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class OrderItemReportEntity 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int orderReportId;
   
	@NotEmpty(message="itemName can not be empty")
	@Column(nullable = false)
	@Size(min=3,max=10,message ="itemName must be minimum 3 charachters and maximum 10")
    private String itemName;
   
	@NotEmpty(message="itemType can not be empty")
	@Column(nullable = false)
	@Size(min=3,max=20,message ="itemType must be minimum 3 charachters and maximum 20")
    private String itemType;
   
	@Column(nullable=false)
	@NotNull(message ="itemPrice can not be empty")
	@Min(message = "Minimum itemPrice should be 20",value=10)
    @Max(message = "Maximum itemPrice should be 1000",value=1000)
    private int itemPrice;
   
	@Column(nullable=false)
	@NotNull(message ="itemQuantity can not be empty")
	@Min(message = "Minimum itemQuantity should be 1",value=1)
    @Max(message = "Maximum itemQuantity should be 50",value=50)
    private int itemQuantity;
	
	@ManyToOne
	@JoinColumn(name = "ino")
	private ItemEntity item;
	
	@ManyToOne
	@JoinColumn(name = "oid")
	private OrderBillEntity orderBill;
	
}
