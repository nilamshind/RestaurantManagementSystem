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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.exceptions.ApiResponse;
import com.boot.payload.CategoryDTO;
import com.boot.service.CategoryService;


@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController 
{
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping// end point to add new record
	@RequestMapping(value="/",method=RequestMethod.POST)//end point or mapping method
	public ResponseEntity<CategoryDTO> addCategory(@Valid @RequestBody CategoryDTO category)
	{
		//ResponseEntity
	
		CategoryDTO addCategory = this.categoryService.addCategory(category);
		
		return new ResponseEntity<CategoryDTO>(addCategory,HttpStatus.CREATED);
		//return addCategory;	
	}
	
	@GetMapping("/")//end point to featch all Category record
	public ResponseEntity<List<CategoryDTO>> getAllCategory()
	{
		List<CategoryDTO> allCategoryList = this.categoryService.getAllCategoryList();
		return new ResponseEntity<List<CategoryDTO>>(allCategoryList,HttpStatus.OK);
		
   }
   
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDTO> getCategory(@PathVariable("categoryId") int categoryId)
	{
		CategoryDTO categoryObj = this.categoryService.getCategoryById(categoryId);
		return new ResponseEntity<CategoryDTO>(categoryObj,HttpStatus.OK);
	}
	
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDTO> updateCategoryById(@Valid @RequestBody CategoryDTO category,@PathVariable("categoryId") int categoryId)
	{
		CategoryDTO updatedCategory = this.categoryService.updateCategoryById(category, categoryId);
		return new ResponseEntity<CategoryDTO>(updatedCategory,HttpStatus.OK);
	}

	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("categoryId") int categoryId)
	{
		this.categoryService.deleteCategoryById(categoryId);
		
		ApiResponse response = new ApiResponse();//api is used to handle custum message 
		
		response.setMessage("Category record deleted by CategoryId "+categoryId);
		response.setStatus(true);
		
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);	
	}
	

}