package com.boot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.exceptions.ApiResponse;
import com.boot.payload.ItemDTO;
import com.boot.service.ItemService;

@RestController
@RequestMapping("/item")
@CrossOrigin("*")
public class ItemController 
{
	@Autowired 
    private ItemService itemService;
 
    @PostMapping("/")// end point to add new record
	 public ResponseEntity<ItemDTO> addItem(@Valid @RequestBody ItemDTO itemDto)
	 {
		
    	ItemDTO addedItem = this.itemService.addItem(itemDto);
		
		return new ResponseEntity<ItemDTO>(addedItem,HttpStatus.CREATED);		
	}
	
    @GetMapping("/")
    public ResponseEntity<List<ItemDTO>> getAllItem()
    {
   	 List<ItemDTO> itemList = this.itemService.getAllItem();
   	 
   	 return new ResponseEntity<List<ItemDTO>>(itemList,HttpStatus.OK);
   	 
    }
	
    @GetMapping("/{itemNo}")
	public ResponseEntity<ItemDTO> getItemById(@PathVariable("itemNo") int itemNo)
	{
    	ItemDTO item = this.itemService.getItemByNo(itemNo);
		return new ResponseEntity<ItemDTO>(item,HttpStatus.OK);
	}
	
	@PutMapping("/{itemNo}")
	public ResponseEntity<ItemDTO> updateItem(@Valid @RequestBody ItemDTO itemDto)
	{
		ItemDTO updatedItem = this.itemService.updateItem(itemDto);
		return new ResponseEntity<ItemDTO>(updatedItem,HttpStatus.OK);
	}

	@DeleteMapping("/{itemNo}")
	public ResponseEntity<ApiResponse> deleteItemById(@PathVariable("itemNo") int itemNo)
	{
		this.itemService.deleteItemByNo(itemNo);
		
		ApiResponse response = new ApiResponse();//Api is used to handle custom message 
		
		response.setMessage("item is deleted successfully with itemNo : "+itemNo);
		response.setStatus(true);
		
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
		
		
	}

}
