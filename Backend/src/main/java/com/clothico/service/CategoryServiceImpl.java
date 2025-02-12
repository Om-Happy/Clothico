package com.clothico.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clothico.dto.CategoryDto;
import com.clothico.entity.Category;
import com.clothico.repository.CategoryDao;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	
	
	@Autowired
	private CategoryDao categorydao;
	
	@Autowired
	private ModelMapper mapper;

	
	
	
	
	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		
		return categorydao.findAll();
	}

	@Override
	public String AddNewCategory(CategoryDto dto) {
		// TODO Auto-generated method stub
		Category category= categorydao.save(mapper.map(dto, Category.class));

		return "Customer Added with Id " + category.getId() + " and Name : " + category.getCategoryname();

	}

	@Override
	public Category getSingleCategory(Long categoryId) {
		// TODO Auto-generated method stub
		Category category = categorydao.findById(categoryId).orElseThrow();

		return category;
	}

	@Override
	public Category UpdateCategory(Long categoryId, CategoryDto dto) {
		// TODO Auto-generated method stub
		Category cat = null;
		if(categorydao.existsById(categoryId)) {
			cat = categorydao.findById(categoryId).orElseThrow();
			cat.setCategoryname(dto.getCategoryname());
			cat.setCategorydescription(dto.getCategorydescription());
		}
		
		Category category = categorydao.save(cat);
		
		return category;
	}

	@Override
	public String deleteCategory(Long categoryId) {
		// TODO Auto-generated method stub
		categorydao.deleteById(categoryId);

		return "Category Deleted";
	}

	
	


	
}
