package com.boot.payload;

import java.util.ArrayList;
import java.util.List;

import com.boot.entity.ItemEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CategoryDTO 
{
	   private int categoryId;
	   
	   private String categoryType;
	   
	   private String categoryDiscription;
	   
	   @JsonIgnore
	   private List<ItemEntity> itemEntityList = new ArrayList<>();
  
}
