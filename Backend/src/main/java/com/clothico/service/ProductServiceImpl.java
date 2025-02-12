package com.clothico.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clothico.dto.ProductDto;
import com.clothico.entity.Product;
import com.clothico.entity.ProductType;
import com.clothico.repository.ProductDao;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productdao;
	
	@Autowired
	private ModelMapper mapper;



	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productdao.findAll();
	}



	@Override
	public String AddNewProduct(ProductDto dto) {
		// TODO Auto-generated method stub
		Product  prod = productdao.save(mapper.map(dto, Product.class));

		return "Product Added with Id " + prod.getId() + " and Name " + prod.getName();
	}



	@Override
	public Product getSingleProduct(Long productId) {
		// TODO Auto-generated method stub
		Product prod = productdao.findById(productId).orElseThrow();

		return prod;
	}



	@Override
	public Product UpdateProduct(Long productId, ProductDto dto) {
		// TODO Auto-generated method stub
		Product p = null;
		if(productdao.existsById(productId)) {
			p = productdao.findById(productId).orElseThrow();
			p.setBrand(dto.getBrand());
			p.setColor(dto.getColor());
			p.setDescription(dto.getDescription());
			p.setName(dto.getName());
		}
		
		Product prod = productdao.save(p);
		
		return prod;
	}



	@Override
	public String deleteProduct(Long productId) {
		// TODO Auto-generated method stub
		productdao.deleteById(productId);

		return "Product Deleted";
	}



	@Override
	public List<Product> getProductsByType(ProductType productType) {
		// TODO Auto-generated method stub
		return productdao.findByProdtype(productType);
	}

	
	


}
