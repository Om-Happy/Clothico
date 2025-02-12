package com.clothico.dto;

import java.time.LocalDate;

import com.clothico.entity.CustomerRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CustomerDto{
	
	@JsonProperty(access = Access.READ_ONLY) // this property only used during ser.
	private Long id;
	
	private String firstname;
	
	private String lastname;
    
	@Email(message = "Invalid Email!!!")
    private String email;
    
	@JsonProperty(access = Access.WRITE_ONLY)
    private String passwd;
    
    private String city;
    
    private String country;

    private CustomerRole role;

	public CustomerDto(String firstname, String lastname, String email, String passwd, String city, String country,
			CustomerRole role) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.passwd = passwd;
		this.city = city;
		this.country = country;
		this.role = role;
	}
    
    
}
