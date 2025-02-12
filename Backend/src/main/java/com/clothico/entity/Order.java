package com.clothico.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Orders")
@NoArgsConstructor

public class Order extends BaseEntity {

//	    @ManyToOne
//	    @JoinColumn(name = "customer_id")
//	    private Customer customer;

	@Column(name = "status")
	private String status;

	@Column(name = "total_amount")
	private BigDecimal totalAmount;

	@Column(name = "shipping_address")
	private String shippingAddress;

	@Column(name = "payment_method")
	private String paymentMethod;

//	    @OneToMany(mappedBy = "order")
//	    private List<OrderItem> items;

	// Unidirectional one-to-many relationship with OrderItem
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<OrderItem> items = new ArrayList<>();

	
	@ManyToOne
	@JoinColumn(name = "customer_id") // optional if you want a specific join column name
	private Customer customer;
	
	public Order(String status, BigDecimal totalAmount, String shippingAddress, String paymentMethod) {
		super();
		this.status = status;
		this.totalAmount = totalAmount;
		this.shippingAddress = shippingAddress;
		this.paymentMethod = paymentMethod;

	}

}
