package com.clothico.dto;

import java.math.BigDecimal;

import com.clothico.entity.Category;
import com.clothico.entity.ProductType;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductDto extends BaseDto{

	
	private String name;

	private String description;

	private BigDecimal price;

	private Integer quantity;

	private String brand;

	private String color;

	private BigDecimal rating;
	
	private ProductType prodtype;
	
}
