package edu.poly.asm_spring.service.Impl;

import edu.poly.asm_spring.dto.AdminDto;
import edu.poly.asm_spring.model.Admin;
import edu.poly.asm_spring.repository.AdminRepository;
import edu.poly.asm_spring.repository.RoleRepository;
import edu.poly.asm_spring.service.AdminService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
	private final AdminRepository adminRepository;
	private final RoleRepository roleRepository;
	
	@Override
	public Admin save(AdminDto adminDto) {
		Admin admin = new Admin();
		admin.setFirstName(adminDto.getFirstName());
		admin.setLastName(adminDto.getLastName());
		admin.setUsername(adminDto.getUsername());
		admin.setPassword(adminDto.getPassword());
		admin.setRoles(Arrays.asList(roleRepository.findByName("ROLE_ADMIN")));
		return adminRepository.save(admin);
	
	}
	
	@Override
	public Admin findByUsername(String username) {
		return adminRepository.findByUsername(username);
	}
	
	
}
