package com.clothico.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.clothico.custom_exceptions.ApiException;
import com.clothico.dto.CustomerDto;
import com.clothico.entity.Customer;
import com.clothico.repository.CustomerDao;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerdao;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerdao.findAll();
	}


//	@Override
//	public Customer SignUp(CustomerDto dto) {
//		// TODO Auto-generated method stub
//		Customer customer  = mapper.map(dto, Customer.class);
//		
//		if(customerdao.existsByEmail(dto.getEmail())){
//			throw new ApiException("Email Already Exists");
//		}
//		
//		customer.setPasswd(encoder.encode(customer.getPasswd()));//password get encrypted here
//		return mapper.map(customerdao.save(customer),Customer.class );
//	}

	
	
	@Override
	public String AddNewCustomer(CustomerDto dto) {
		// TODO Auto-generated method stub
		
		String encryptPasswd = encoder.encode(dto.getPasswd());
		System.out.println(encryptPasswd);
		
		Customer customer  = mapper.map(dto, Customer.class);
		customer.setPasswd(encryptPasswd);
		
		if(customerdao.existsByEmail(dto.getEmail())){
			throw new ApiException("Email Already Exists");
		}
		
		
		//password get encrypted here
		customerdao.save(customer);

		return "Customer Added with Email " + customer.getEmail();
	}

	@Override
	public List<String> getSingleCustomer(Long customerId) {
		// TODO Auto-generated method stub
		
		
		Customer cust = customerdao.findById(customerId).orElseThrow();
		
		String orders = cust.getOrders().stream()
                .map(order -> order.toString()) // or use order.getOrderDetails() if you need a specific property
                .collect(Collectors.joining(", ")); // Joins order details with commas

		String role = cust.getRole().toString();
		
		return Arrays.asList(cust.getFirstname(),cust.getLastname(),cust.getEmail(),
							 cust.getCity(),cust.getCountry(),orders,role);

	}

	@Override
	public Customer UpdateCustomer(Long customerId, CustomerDto dto) {
		// TODO Auto-generated method stub

		Customer c = null;
		if (customerdao.existsById(customerId)) {
			c = customerdao.findById(customerId).orElseThrow();

			c.setCity(dto.getCity());
			c.setCountry(dto.getCountry());
			c.setEmail(dto.getEmail());
			c.setFirstname(dto.getFirstname());
			c.setLastname(dto.getLastname());
			
			String encryptPasswd = encoder.encode(dto.getPasswd());
			System.out.println(encryptPasswd);
			
//			Customer customer  = mapper.map(dto, Customer.class);
//			customer.setPasswd(encryptPasswd);
			
			c.setPasswd(encryptPasswd);

		}

		Customer cust = customerdao.save(c);

		return cust;
	}

	@Override
	public String deleteCustomer(Long customerId) {
		// TODO Auto-generated method stub
		customerdao.deleteById(customerId);

		return "deleted Customer details";
	}

}
