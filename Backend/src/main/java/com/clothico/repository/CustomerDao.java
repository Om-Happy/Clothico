package com.clothico.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clothico.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Long>{
	Optional<Customer>  findByEmail(String email);
	//derived query method
		boolean existsByEmail(String email);
}
