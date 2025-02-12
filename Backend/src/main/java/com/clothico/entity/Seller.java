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
@ToString(exclude = "passwd",callSuper = true)
@Table(name ="Seller")
@NoArgsConstructor

public class Seller extends BaseEntity{

	@Column(name = "store_name")  
	private String storename;
	
	@Column(name = "first_name")
	private String firstname;
	
	@Column(name = "last_name")
	private String lastname;
	
	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String passwd;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "role")
	private SellerRole role;
	
	
	 @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	    private List<Product> products = new ArrayList<>();

	public Seller(String storename, String firstname, String lastname, String email, String passwd, String city,
			String country, SellerRole role) {
		super();
		this.storename = storename;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.passwd = passwd;
		this.city = city;
		this.country = country;
		this.role = role;
	}
	

	

	
	
	
}
