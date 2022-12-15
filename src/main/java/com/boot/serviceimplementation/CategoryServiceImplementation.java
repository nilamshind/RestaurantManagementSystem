package com.boot.serviceimplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.CategoryEntity;
import com.boot.exceptions.ResourceNotFoundException;
import com.boot.payload.CategoryDTO;
import com.boot.repository.CategoryRepository;
import com.boot.service.CategoryService;

@Service
public class CategoryServiceImplementation implements CategoryService
{
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDTO addCategory(CategoryDTO category) 
	{
		// TODO Auto-generated method stub
		CategoryEntity categoryEntity = this.modelMapper.map(category, CategoryEntity.class);
		
		CategoryEntity savedCategoryEntity = this.categoryRepository.save(categoryEntity);
		
		return this.modelMapper.map(savedCategoryEntity, CategoryDTO.class);
		
	}

	@Override
	public List<CategoryDTO> getAllCategoryList() 
	{
		// TODO Auto-generated method stub
		List<CategoryEntity> categoryList =this.categoryRepository.findAll();
		List<CategoryDTO>  categoryListDto = categoryList.stream().map(category->this.modelMapper.map(category, CategoryDTO.class))
				.collect(Collectors.toList());
		return categoryListDto;
	}

	@Override
	public CategoryDTO getCategoryById(int categoryId) 
	{
		// TODO Auto-generated method stub
		CategoryEntity categoryObj = this.categoryRepository
				.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category","categoryId",categoryId));
				return this.modelMapper.map(categoryObj, CategoryDTO.class);
		
	}

	@Override
	public void deleteCategoryById(int categoryId) 
	{
		// TODO Auto-generated method stub
		if(this.categoryRepository.existsById(categoryId)) 
		{
			this.categoryRepository.deleteById(categoryId);
			
		}
		else
		{
			throw new ResourceNotFoundException("Category","CategoryId", categoryId);
		}
		
	}

	@Override
	public CategoryDTO updateCategoryById(CategoryDTO category, int categoryId)
	{
		// TODO Auto-generated method stub
		if(this.categoryRepository.existsById(categoryId)) 
		{
			CategoryEntity categoryObj = this.modelMapper.map(category,CategoryEntity.class);
			CategoryEntity updatedCategory= this.categoryRepository.save(categoryObj);
			
			return this.modelMapper.map(updatedCategory, CategoryDTO.class);
		}
		else
		{
			throw new ResourceNotFoundException("Category","CategoryId", categoryId);
		}
		
	}

}
