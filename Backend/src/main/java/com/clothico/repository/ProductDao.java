package com.clothico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clothico.entity.Product;
import com.clothico.entity.ProductType;

public interface ProductDao extends JpaRepository<Product, Long>{

	List<Product> findByProdtype(ProductType prodtype);
	
}
