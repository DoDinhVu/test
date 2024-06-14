package edu.poly.asm_spring.repository;

import edu.poly.asm_spring.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
	Admin findByUsername(String username);
}
