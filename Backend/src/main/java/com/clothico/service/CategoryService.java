package com.clothico.service;

import java.util.List;
import java.util.Optional;

import com.clothico.dto.CategoryDto;
import com.clothico.entity.Category;

public interface CategoryService {

	List<Category> getAllCategory();

	String AddNewCategory(CategoryDto dto);

	Category getSingleCategory(Long categoryId);
	
	Category UpdateCategory(Long categoryId, CategoryDto customer);

	String deleteCategory(Long categoryId);

	



}
