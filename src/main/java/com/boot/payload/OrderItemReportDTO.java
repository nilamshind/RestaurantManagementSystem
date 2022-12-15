package com.boot.payload;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.boot.entity.ItemEntity;
import com.boot.entity.OrderBillEntity;
import com.boot.entity.OrderItemReportEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrderItemReportDTO 
{
	   private int orderReportId;
	   
	   private String itemName;
	   
	   private String itemType;
	   
	   private int itemPrice;

	   private ItemDTO item;
	   
	   private int itemQuantity;
	   
	   private OrderBillDTO orderBill;
}
