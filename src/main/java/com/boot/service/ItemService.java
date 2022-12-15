package com.boot.service;

import java.util.List;

import com.boot.payload.ItemDTO;

public interface ItemService 
{
	//To add new Item
		public ItemDTO addItem(ItemDTO item);
		
		//Get all the Item
		public List<ItemDTO> getAllItem();
		
		//To add new Item
		public ItemDTO getItemByNo(int ItemNo);
		
		//Update Item
		public ItemDTO updateItem(ItemDTO item);
		
		//delete itemByNo
		public void deleteItemByNo(int itemNo);
}
