package com.boot.service;

import java.util.List;

import com.boot.payload.CategoryDTO;

public interface CategoryService 
{
	  public CategoryDTO addCategory(CategoryDTO category);

	  public List<CategoryDTO> getAllCategoryList();
	  
	  public CategoryDTO getCategoryById(int categoryId);
	  
	  public void deleteCategoryById(int categoryId);
	  
	  public CategoryDTO updateCategoryById(CategoryDTO category, int categoryId);
	 
}
