package com.clothico.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(callSuper = true, exclude = { "selectedCategory" })
@Table(name = "Products")
@NoArgsConstructor

public class Product extends BaseEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "quantity")
	private Integer quantity;

//	@ManyToOne
//	@JoinColumn(name = "category_id")
//	private Category category;

	@Column(name = "brand")
	private String brand;

	@Column(name = "color")
	private String color;

	@Column(name = "rating")
	private BigDecimal rating;

//	product *---> 1 category
//	@ManyToOne
//	@JoinColumn(name = "category_id", nullable = false)
//	private Category selectedCategory;

	@Enumerated(EnumType.STRING)
	private ProductType prodtype;

	// Unidirectional many-to-one relationship with Category
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "seller_id") // Foreign key to the Seller entity
	private Seller seller;

	public Product(String name, String description, BigDecimal price, Integer quantity, String brand, String color,
			BigDecimal rating, ProductType prodtype) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.brand = brand;
		this.color = color;
		this.rating = rating;
		this.prodtype = prodtype;
	}

}
