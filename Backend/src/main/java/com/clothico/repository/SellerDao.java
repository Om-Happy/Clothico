package com.clothico.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clothico.entity.Seller;

public interface SellerDao extends JpaRepository<Seller, Long>{

	Seller findByEmail(String emailId);

}
