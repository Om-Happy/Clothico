package com.clothico.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clothico.dto.OrderDto;
import com.clothico.entity.Order;
import com.clothico.repository.OrderDao;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class OrderServiceImpl implements OrderService{

	
	
	
	@Autowired
	private OrderDao orderdao;
	
	@Autowired
	private ModelMapper mapper;
	

	@Override
	public List<Order> getAllOrder() {
		// TODO Auto-generated method stub
		return orderdao.findAll();
	}

	@Override
	public String AddNewOrder(OrderDto dto) {
		// TODO Auto-generated method stub
		Order order = orderdao.save(mapper.map(dto, Order.class));

		return "Customer Added with Id " + order.getId();

	}

	@Override
	public Order getSingleOrder(Long orderId) {
		// TODO Auto-generated method stub
		Order order = orderdao.findById(orderId).orElseThrow();

		return order;
	}

	@Override
	public Order UpdateOrder(Long orderId, OrderDto dto) {
		// TODO Auto-generated method stub
		Order o = null;
		if(orderdao.existsById(orderId)) {
			o = orderdao.findById(orderId).orElseThrow();
			o.setShippingAddress(o.getShippingAddress());
			o.setStatus(o.getStatus());
			o.setTotalAmount(o.getTotalAmount());
		}
		
		Order  order = orderdao.save(o);
		
		return order;
	}

	@Override
	public String deleteOrder(Long orderId) {
		// TODO Auto-generated method stub
		orderdao.deleteById(orderId);

		return "Order deleted";
	}
	
	
	
	
	
	
	
	

	

}
