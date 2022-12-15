package com.boot.payload;


import java.util.ArrayList;
import java.util.List;

import com.boot.entity.CategoryEntity;
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
public class ItemDTO 
{
	private int itemNo;
	   
	   private String itemName;
	   
	   private int itemPrice;
	   
	   private String itemType;
	   
	   
	   private CategoryDTO category;
	   
	   @JsonIgnore
	   private List<OrderItemReportEntity> orderItemReportList = new ArrayList<>();
}
