package com.clothico.security;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import lombok.AllArgsConstructor;

@EnableWebSecurity // - required in earlier spring sec versions -enabled by default
@Configuration // equivalent to bean config xml file
@AllArgsConstructor
public class SecurityConfig {

	private PasswordEncoder encoder;
	private CustomJwtAuthenticationFilter jwtFilter;

	// Configure the bean to customize spring security filter chain
	@Bean
	public SecurityFilterChain authorizeRequests(HttpSecurity http) throws Exception {
		http
		.cors(cors -> cors.configurationSource(corsConfigurationSource()))
		.csrf(customizer -> customizer.disable())
				.authorizeHttpRequests(request -> request
						.requestMatchers("/Home/ViewProducts",
										 "/Home/ShowProduct/*",//will match with only single directory level i.e. /Home/ShowProduct/1 
										 "/Home/men/**", 
										 "/Home/women/**",
										 "/Home/SignUp",
										 "/Home/SignIn",
										 "/v*/api-doc*/**",
										 "/swagger-ui/**") 
						.permitAll().requestMatchers(HttpMethod.OPTIONS).permitAll()

						.requestMatchers("/Customer/ViewProfile/*",
										 "/Customer/DeleteCustomer/*"
										 
										).hasRole("CUSTOMER")
						.requestMatchers("/products/add", "/products/delete").hasRole("ADMIN").anyRequest()
						.authenticated())
	//			.httpBasic(Customizer.withDefaults()) replacing Basic Auth by custom JWT based auth
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		
		System.out.println("http content: "+http);
		return http.build();
	}

	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
	    CorsConfiguration configuration = new CorsConfiguration();
	    configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:4200"));
	    configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
	    configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
	    configuration.setExposedHeaders(Collections.singletonList("Authorization"));
	    configuration.setAllowCredentials(true);
	    configuration.setMaxAge(3600L);

	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", configuration); // ✅ Apply CORS to all endpoints
	    return source;
	}
	
	
	
	// configure AuthMgr as a spring bean
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		
		System.out.println("congfig got as : "+config);
		return config.getAuthenticationManager();
	}
}
