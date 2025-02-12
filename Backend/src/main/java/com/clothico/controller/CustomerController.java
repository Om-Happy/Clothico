package com.clothico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clothico.dto.ApiResponse;
import com.clothico.dto.CustomerDto;
import com.clothico.dto.OrderDto;
import com.clothico.entity.Customer;
import com.clothico.entity.Order;
import com.clothico.service.CustomerService;
import com.clothico.service.OrderService;

import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/Customer")
public class CustomerController {

	
	//This Api only accessible to authorised customer i.e Logged in customer
	
	public CustomerController() {
		System.out.println("In Customer Controller"+getClass());
	}
	
	@Autowired
	private CustomerService customerservice;
	
	@Autowired
	private OrderService orderservice;
	

	
	
	
	@GetMapping({"/ViewProfile/{customerId}"})
	public ResponseEntity<?> getSingleCustomer(@PathVariable Long customerId){
		System.out.println("Inside of View Profile");
		return ResponseEntity.ok(customerservice.getSingleCustomer(customerId));
	
	} 
	
	@PutMapping({"/Edit/{customerId}"})
	public ResponseEntity<?> UpdateCustomer(@PathVariable Long customerId, @RequestBody CustomerDto dto ) {
		//TODO: process PUT request	
//		Customer customer = customerservice.getSingleCustomer(customerId);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(customerservice.UpdateCustomer(customerId, dto));
	}
	 
		
	@DeleteMapping("/DeleteCustomer/{customerId}")
	public ResponseEntity<?>DeleteCustomer(@PathVariable Long customerId){
		
		return ResponseEntity.ok(new ApiResponse(customerservice.deleteCustomer(customerId)));
	}
	
	
	
	
	@PostMapping("/BuyProduct")
	public ResponseEntity<?> AddNewOrder(@RequestBody OrderDto order) {
		//TODO: process POST request 
	
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ApiResponse(orderservice.AddNewOrder(order)));
	}
	

	@DeleteMapping("/Order/{orderId}")
	public ResponseEntity<?>DeleteOrder(@PathVariable Long orderId){
		
		return ResponseEntity.ok(new ApiResponse(orderservice.deleteOrder(orderId)));
	}
	
	
	@GetMapping({"/{orderId}"})
	public ResponseEntity<?> getSingleOrder(@PathVariable Long orderId){
		
		return ResponseEntity.ok(orderservice.getSingleOrder(orderId));
	
	} 
	
	@PutMapping({"/{orderId}"})
	public ResponseEntity<?> UpdateOrder(@PathVariable Long orderId, @RequestBody OrderDto dto ) {
		//TODO: process PUT request	
//		Customer customer = customerservice.getSingleCustomer(customerId);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(orderservice.UpdateOrder(orderId, dto));
	}
	
	
	
	
}
