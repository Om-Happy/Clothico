package com.clothico.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(exclude = "passwd",callSuper = true)
@Table(name ="Customers")
@NoArgsConstructor
public class Customer extends BaseEntity{

	
	
	@Column(name = "first_name")
	private String firstname;
	
	@Column(name = "last_name")
	private String lastname;
	
	@Column(name = "email")
	private String email;

	@Column(name = "passwd")
	private String passwd;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "country")
	private String country;

	@Enumerated(EnumType.STRING)
	@Column(length = 50, name = "role")
	private CustomerRole role;
	
//	@OneToMany
//	private List<Order> orders = new ArrayList<>();
//	
//	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Order> orders = new ArrayList<>();

	public Customer(String firstname, String lastname, String email, String passwd, String city, String country,
			CustomerRole role) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.passwd = passwd;
		this.city = city;
		this.country = country;
		this.role = role;
	}

	
	
	


}
