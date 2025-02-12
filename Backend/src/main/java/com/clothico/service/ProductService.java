package com.clothico.service;

import java.util.List;

import com.clothico.dto.ProductDto;
import com.clothico.entity.Customer;
import com.clothico.entity.Product;
import com.clothico.entity.ProductType;

public interface ProductService {

	List<Product>getAllProduct();	
	
	String AddNewProduct(ProductDto dto);
	
	Product getSingleProduct(Long productId);
	
	Product UpdateProduct(Long productId, ProductDto dto);
	
	String deleteProduct(Long productId);

	List<Product> getProductsByType(ProductType productType);
	
}
