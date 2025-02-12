package com.clothico.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clothico.dto.ApiResponse;
import com.clothico.dto.CustomerDto;
import com.clothico.dto.SigninRequest;
import com.clothico.dto.SigninResponse;
import com.clothico.entity.Product;
import com.clothico.entity.ProductType;
import com.clothico.security.JwtUtils;
import com.clothico.service.CustomerService;
import com.clothico.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Home")
public class HomeController {

	//This Api Accessible to all
	
	
	@Autowired
	private ProductService productservice;
	
	@Autowired
	private CustomerService customerservice;
	
	
	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private AuthenticationManager authMgr;

	
	@GetMapping("/ViewProducts")
	public List<Product> GetAllProducts(){
//		System.out.println("In get all Product");
		// 200 : OK , 204 : No content
		return productservice.getAllProduct();
		
	}

	
	@GetMapping({"/ShowProduct/{productId}"})
	public ResponseEntity<?> getSingleProduct(@PathVariable Long productId){
		
		return ResponseEntity.ok(productservice.getSingleProduct(productId));
	
	}
	
	
	@GetMapping("/men")
    public List<Product> getMensProducts() {
        return productservice.getProductsByType(ProductType.MEN);  // Correct enum usage
    }

    // Endpoint to get women's products
    @GetMapping("/women")
    public List<Product> getWomensProducts() {
        return productservice.getProductsByType(ProductType.WOMEN);  // Correct enum usage
    }
	
    @PostMapping("/SignUp")
	public ResponseEntity<?> AddNewCustomer(@RequestBody CustomerDto customer) {
		//TODO: process POST request 
	
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ApiResponse(customerservice.AddNewCustomer(customer)));
	}
	
	
	
//	@PostMapping("/SignIn")
//	public String postMethodName(@RequestBody String entity) {
//		//TODO: process POST request
//		
//		return entity;
//	}
	
	
	@PostMapping("/SignIn")
	public ResponseEntity<?> authenticateUser(@RequestBody @Valid SigninRequest request) {
		System.out.println("in sign in" + request);//=> email n password : valid(P.L)
		// 1. create a token(implementation of Authentication i/f)
		// to store un verified user email n pwd
		UsernamePasswordAuthenticationToken token = 
				new UsernamePasswordAuthenticationToken(request.getEmail(),
				request.getPassword());
		System.out.println("after UsernamePasswordAuthenticationToken ");
		//2.  invoke auth mgr's authenticate method;
		Authentication verifiedToken = authMgr.authenticate(token);
			// => authentication successful !
			//3. In case of successful auth,  
		//create JWT n send it to the clnt in response
		System.out.println("after verifiedToken");
		
		SigninResponse resp = new SigninResponse
				(jwtUtils.generateJwtToken(verifiedToken), "Successful Auth!!!!");
		return ResponseEntity.status(HttpStatus.CREATED).body(resp);
	}
	
	
	
//	@PostMapping("/signin")
//	public ResponseEntity<?> validateUserCreateToken(@RequestBody @Valid SigninRequest request, HttpServletRequest httpServletRequest) throws Exception {
//		// store incoming user details(not yet validated) into Authentication object
//		System.out.println(httpServletRequest.getRemoteAddr());
//		// Authentication i/f ---> implemented by UserNamePasswordAuthToken
//		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(request.getEmail(),
//				request.getPassword());
////		log.info("auth token before {}",authToken);
//		try {
//			// authenticate the credentials
//			Authentication authenticatedDetails = authMgr.authenticate(authToken);
////			log.info("auth token again {} " , authenticatedDetails);
//			// => auth succcess
//			
//			Object obj = userService.temporaryValidateUser(request.getEmail());
//			if(obj instanceof PatientDTO) {
//				PatientDTO patient = (PatientDTO)obj;
//				patient.setJwt(utils.generateJwtToken(authenticatedDetails));
//				patient.setMessage("Authentication Successfull");
//				return ResponseEntity.status(HttpStatus.ACCEPTED).body(patient);
//			}
//			if(obj instanceof DoctorDTO) {
//				DoctorDTO doctor = (DoctorDTO)obj;
//				doctor.setJwt(utils.generateJwtToken(authenticatedDetails));
//				doctor.setMessage("Authentication Successfull");
//				return ResponseEntity.status(HttpStatus.ACCEPTED).body(doctor);
//			}
//			if(obj instanceof AdminDTO) {
//				AdminDTO admin = (AdminDTO)obj;
//				Set<RoleEnum> loginRole = new HashSet<>();
//				loginRole.add(RoleEnum.valueOf("ROLE_ADMIN"));
//				admin.setRoles(loginRole);
//				admin.setJwt(utils.generateJwtToken(authenticatedDetails));
//				admin.setMessage("Authentication Successfull");
//				return ResponseEntity.status(HttpStatus.ACCEPTED).body(admin);
//			}
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Your role not found");
//			
//			
//			
//		} catch (BadCredentialsException e) { // lab work : replace this by a method in global exc handler
//			// send back err resp code
//			System.out.println("err "+e);
//			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
//		}

	
	
	
	
	
	
	
	
}
