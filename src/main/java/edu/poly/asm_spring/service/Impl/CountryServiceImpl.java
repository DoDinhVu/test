package edu.poly.asm_spring.service.Impl;

import edu.poly.asm_spring.model.Country;
import edu.poly.asm_spring.repository.CountryRepository;
import edu.poly.asm_spring.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
	private final CountryRepository countryRepository;
	
	@Override
	public List<Country> findAll() {
		return countryRepository.findAll();
	}
}