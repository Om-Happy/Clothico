package com.clothico.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.clothico.entity.Customer;
import com.clothico.repository.CustomerDao;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class CustomCustomerDetailsService implements UserDetailsService {
	// depcy
	private CustomerDao customerdao;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Customer customer = customerdao.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Invalid Email !!!"));
		return new CustomCustomerDetails(customer);
	}

}
