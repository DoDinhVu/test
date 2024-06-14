package edu.poly.asm_spring.service.Impl;

import edu.poly.asm_spring.model.City;
import edu.poly.asm_spring.repository.CityRepository;
import edu.poly.asm_spring.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
	private final CityRepository cityRepository;
	
	@Override
	public List<City> findAll() {
		return cityRepository.findAll();
	}
}
