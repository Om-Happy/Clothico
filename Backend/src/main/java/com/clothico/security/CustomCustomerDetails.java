package com.clothico.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.clothico.entity.Customer;

//import io.jsonwebtoken.Claims;


public class CustomCustomerDetails implements UserDetails {
	
	private Customer customer;

	public CustomCustomerDetails(Customer customer) {
		super();
		this.customer = customer;
		System.out.println("In CustomCustomerDetails");
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		System.out.println("Role of user = "+customer.getRole());	
		return List.of(new SimpleGrantedAuthority(
				customer.getRole().toString()));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return customer.getPasswd();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return customer.getEmail();
	}

	
	public Customer getUser() {
		return customer;
	}
	

	

}
