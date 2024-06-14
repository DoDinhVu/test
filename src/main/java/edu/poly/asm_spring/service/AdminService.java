package edu.poly.asm_spring.service;

import edu.poly.asm_spring.dto.AdminDto;
import edu.poly.asm_spring.model.Admin;

public interface AdminService {
	public Admin save(AdminDto adminDto);
	public Admin findByUsername(String username);
}
