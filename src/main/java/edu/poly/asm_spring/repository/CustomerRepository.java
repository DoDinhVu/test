package edu.poly.asm_spring.repository;

import edu.poly.asm_spring.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	public Customer findByUsername(String username);
}
