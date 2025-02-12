package com.clothico.dto;

import java.time.LocalDate;

import com.clothico.entity.CustomerRole;
import com.clothico.entity.SellerRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

public class SellerDto {

	@JsonProperty(access = Access.READ_ONLY) // this property only used during ser.
	private Long id;
	
	private String storename;
	
	@Email(message = "Invalid Email!!!")
    private String email;
    
    private String city;
    
    private String country;
    
    @JsonProperty(access = Access.WRITE_ONLY)
    private String passwd;
       
    
	private SellerRole role;


	public SellerDto(String storename, String email, String city, String country, String password, SellerRole role) {
		super();
		this.storename = storename;
		this.email = email;
		this.city = city;
		this.country = country;
		this.passwd = password;
		this.role = role;
	}

 
   
}
