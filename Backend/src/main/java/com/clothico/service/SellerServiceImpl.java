package com.clothico.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clothico.dto.SellerDto;
import com.clothico.entity.Seller;
import com.clothico.repository.SellerDao;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerDao sellerdao;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<Seller> getAllSeller() {
		// TODO Auto-generated method stub
		return sellerdao.findAll();
	}

	@Override
	public String AddNewSeller(SellerDto dto) {
		// TODO Auto-generated method stub
		Seller seller = sellerdao.save(mapper.map(dto, Seller.class));

		return "Customer Added with Id " + seller.getId() + " and Email " + seller.getEmail();

	}

	@Override
	public Seller getSingleSeller(Long sellerId) {
		// TODO Auto-generated method stub
		Seller seller = sellerdao.findById(sellerId).orElseThrow();

		return seller;
	}

	@Override
	public Seller UpdateSeller(Long sellerId, SellerDto dto) {
		// TODO Auto-generated method stub

		Seller s = null;
		if (sellerdao.existsById(sellerId)) {
			s = sellerdao.findById(sellerId).orElseThrow();
			
			s.setCity(dto.getCity());
			s.setCountry(dto.getCountry());
			s.setEmail(dto.getEmail());
			s.setPasswd(dto.getPasswd());
			s.setStorename(dto.getStorename());

		}

		Seller seller = sellerdao.save(s);
		return seller;
	}

	@Override
	public String deleteSeller(Long sellerId) {
		// TODO Auto-generated method stub
		sellerdao.deleteById(sellerId);

		return "Deleted Seller details";
	}

	@Override
	public Seller SignIn(String shopname, String shopId, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
