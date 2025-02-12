package com.clothico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clothico.dto.ApiResponse;
import com.clothico.entity.Customer;
import com.clothico.entity.Seller;
import com.clothico.service.CustomerService;
import com.clothico.service.SellerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/Seller")
public class SellerController {

	//This Api only accessible to authorised Seller i.e Logged in Seller
	
	@Autowired
	private SellerService sellerservice;
	
	@Autowired
	private CustomerService customerservice;
	

	
	@GetMapping
	public List<Seller> getAllSeller(){
		System.out.println("in get all categories");
		// 200 : OK , 204 : No content
		return sellerservice.getAllSeller();

	}
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomer(){
		System.out.println("in get all categories");
		// 200 : OK , 204 : No content
		return customerservice.getAllCustomer();
		
	}
	
	@PostMapping("/SignIn")
	public String postMethodName(@RequestBody String entity) {
		//TODO: process POST request
		
		return entity;
	}
	

	

	
	
	
	
	
	
}
