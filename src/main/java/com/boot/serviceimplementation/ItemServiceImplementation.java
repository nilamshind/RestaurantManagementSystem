package com.boot.serviceimplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.ItemEntity;
import com.boot.exceptions.ResourceNotFoundException;
import com.boot.payload.ItemDTO;
import com.boot.repository.ItemRepository;
import com.boot.service.ItemService;

@Service
public class ItemServiceImplementation implements ItemService
{
    
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired 
	private ModelMapper modelMapper;
	
	@Override
	public ItemDTO addItem(ItemDTO item) 
	{
		// TODO Auto-generated method stub
		ItemEntity itemEntity = this.modelMapper.map(item,ItemEntity.class);
		ItemEntity savedItem = this.itemRepository.save(itemEntity); 	

		return this.modelMapper.map(savedItem, ItemDTO.class);
	}

	@Override
	public List<ItemDTO> getAllItem() 
	{
		// TODO Auto-generated method stub
		List<ItemEntity> itemList =this.itemRepository.findAll();
		List<ItemDTO>  itemDTOList = itemList.stream().map(item->this.modelMapper.map(item, ItemDTO.class))
				.collect(Collectors.toList());
		return itemDTOList;
	}

	@Override
	public ItemDTO getItemByNo(int ItemNo) 
	{
		// TODO Auto-generated method stub
		ItemEntity itemObj = this.itemRepository
				.findById(ItemNo).orElseThrow(()-> new ResourceNotFoundException("item","itemNo",ItemNo));
				return this.modelMapper.map(itemObj, ItemDTO.class);
	}

	@Override
	public ItemDTO updateItem(ItemDTO item) 
	{
		// TODO Auto-generated method stub
		if(this.itemRepository.existsById(item.getItemNo()))
		{
			ItemEntity itemObj = this.modelMapper.map(item,ItemEntity.class);
			ItemEntity updatedItem= this.itemRepository.save(itemObj);
			
			return this.modelMapper.map(updatedItem, ItemDTO.class);
		}
		else
		{
			throw new ResourceNotFoundException("item","ItemNo", item.getItemNo());
		}
		
	}

	@Override
	public void deleteItemByNo(int itemNo) 
	{
		// TODO Auto-generated method stub
		if(this.itemRepository.existsById(itemNo)) 
		{
			this.itemRepository.deleteById(itemNo);
			
		}
		else
		{
			throw new ResourceNotFoundException("Item","ItemNo", itemNo);
		}
		
	}

}
