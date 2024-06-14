package edu.poly.asm_spring.service.Impl;

import edu.poly.asm_spring.dto.CustomerDto;
import edu.poly.asm_spring.model.Customer;
import edu.poly.asm_spring.repository.CustomerRepository;
import edu.poly.asm_spring.repository.RoleRepository;
import edu.poly.asm_spring.service.CustomerService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
	private final CustomerRepository customerRepository;
	private final RoleRepository roleRepository;
	
	
	@Override
	public Customer save(CustomerDto customerDto) {
		Customer customer = new Customer();
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setPassWord(customerDto.getPassword());
		customer.setRoles(Arrays.asList(roleRepository.findByName("CUSTOMER")));
		return customerRepository.save(customer);
	}
	
	@Override
	public Customer findByUsername(String username) {
		return customerRepository.findByUsername(username);
	}
	
	@Override
	public Customer update(CustomerDto customerDto) {
		Customer customer = customerRepository.findByUsername(customerDto.getUsername());
		customer.setAddress(customerDto.getAddress());
		customer.setCity(customerDto.getCity());
		customer.setCountry(customerDto.getCountry());
		customer.setPhoneNumber(customerDto.getPhoneNumber());
		return customerRepository.save(customer);
	}
	
	@Override
	public Customer changePass(CustomerDto customerDto) {
		Customer customer = customerRepository.findByUsername(customerDto.getUsername());
		customer.setPassWord(customerDto.getPassword());
		return customerRepository.save(customer);
	}
	
	@Override
	public CustomerDto getCustomer(String username) {
		CustomerDto customerDto = new CustomerDto();
		Customer customer = customerRepository.findByUsername(username);
		customerDto.setFirstName(customer.getFirstName());
		customerDto.setLastName(customer.getLastName());
		customerDto.setUsername(customer.getUsername());
		customerDto.setPassword(customer.getPassWord());
		customerDto.setAddress(customer.getAddress());
		customerDto.setPhoneNumber(customer.getPhoneNumber());
		customerDto.setCity(customer.getCity());
		customerDto.setCountry(customer.getCountry());
		return customerDto;
	}
	
}
