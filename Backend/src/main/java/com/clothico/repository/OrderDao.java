package com.clothico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clothico.entity.Order;

public interface OrderDao extends JpaRepository<Order, Long>{

}
