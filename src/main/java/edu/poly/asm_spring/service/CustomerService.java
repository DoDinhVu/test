package edu.poly.asm_spring.service;

import edu.poly.asm_spring.dto.CustomerDto;
import edu.poly.asm_spring.model.Customer;

public interface CustomerService {
	Customer save(CustomerDto customerDto);
	
	Customer findByUsername(String username);
	
	Customer update(CustomerDto customerDto);
	
	Customer changePass(CustomerDto customerDto);
	
	CustomerDto getCustomer(String username);
}
