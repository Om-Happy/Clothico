package com.clothico.service;

import java.util.List;

import com.clothico.dto.OrderDto;
import com.clothico.entity.Customer;
import com.clothico.entity.Order;
import com.clothico.entity.Product;

public interface OrderService {

	List<Order>getAllOrder();	//called by admin and customer
	
	String AddNewOrder(OrderDto dto); //called by admin and customer
	
	Order getSingleOrder(Long orderId); //called by admin and customer
	
	Order UpdateOrder(Long orderId, OrderDto dto); //called by admin and customer
	
	String deleteOrder(Long orderId); //called by admin and customer
	
}
