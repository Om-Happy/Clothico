package com.clothico.service;

import java.util.List;

import com.clothico.dto.CustomerDto;
import com.clothico.entity.Customer;

public interface CustomerService {


	List<Customer>getAllCustomer();	
	
	String AddNewCustomer(CustomerDto customer);
	
	List<String> getSingleCustomer(Long customerId);
	
	String deleteCustomer(Long customerId);

	Customer UpdateCustomer(Long customerId, CustomerDto dto);

//	String UpdateCustomer(Long customerId);
	
//	Customer UpdateCustomer(Customer customer);
	
//	Customer SignUp(CustomerDto dto);
	
		
}
