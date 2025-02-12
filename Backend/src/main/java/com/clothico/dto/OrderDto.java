package com.clothico.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class OrderDto extends BaseDto {

	    private Long id;
	    
	    private String customerName;
	    
	    private String orderDate;
	    
	    private String status;
	    
	    private BigDecimal totalAmount;
	    
	    private String shippingAddress;
	    
	    private String paymentMethod;
//	    private List<OrderItemDTO> items;


	 
	  



}
