package com.clothico.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(callSuper = true,exclude ="product")
@Table(name ="Categories")
@NoArgsConstructor
public class Category extends BaseEntity{


	@Column(name = "CategoryName")
	private String categoryname;
	
	@Column(name = "Description")
	private String categorydescription;
	
//	@OneToMany(mappedBy = "selectedCategory", 
//			cascade = CascadeType.ALL /* ,fetch = FetchType.EAGER */ ,
//			orphanRemoval = true)
//	private List<Product> product= new ArrayList<>();

	 @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	    private List<Product> products = new ArrayList<>();

	
	
	public Category(String categoryname, String categorydescription) {
		super();
		this.categoryname = categoryname;
		this.categorydescription = categorydescription;
	}

	 
}
