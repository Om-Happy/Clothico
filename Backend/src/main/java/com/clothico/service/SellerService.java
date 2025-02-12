package com.clothico.service;

import java.util.List;

import com.clothico.dto.SellerDto;
import com.clothico.entity.Seller;

public interface SellerService{

	
	List<Seller> getAllSeller();	
	
	String AddNewSeller(SellerDto dto);
	
	Seller getSingleSeller(Long sellerId);
		
	Seller UpdateSeller(Long sellerId, SellerDto dto);
		
	String deleteSeller(Long sellerId);
	
	Seller SignIn(String shopname, String email, String password);

//	Seller getSingleSeller(String emailId);

	
}
