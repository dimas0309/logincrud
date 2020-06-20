package com.dagtech.logincrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dagtech.logincrud.dao.ProviderRepository;
import com.dagtech.logincrud.entity.Provider;

@Service
public class ProviderServiceImpl implements ProviderService {
	
	private ProviderRepository providerRepository;
	
	@Autowired
	public ProviderServiceImpl(ProviderRepository pRepository) {
		providerRepository = pRepository;
	}

	@Override
	public List<Provider> findAll() {
		
		// method to retrieve all providers by company
		return providerRepository.findAllByOrderByCompanyAsc();
	}

	@Override
	public Provider findById(int id) {
		
		// method to retrieve a provider by id
		Optional <Provider> result = providerRepository.findById(id);
		
		Provider provider = null;
		
		if(result.isPresent()) {
			provider = result.get();
		}
		else {
			throw new RuntimeException("Did not find provider id - " + id);
		}
		
		return provider;
	}

	@Override
	public void save(Provider provider) {
		
		// method to save a provider
		providerRepository.save(provider);
	}

	@Override
	public void delete(int id) {
		
		// method to delete a provider
		providerRepository.deleteById(id);

	}


	@Override
	public List<Provider> searchBy(String theName) {
		
		// method to search a provider
		List<Provider> results = null;
		
		if(theName != null && (theName.trim().length() > 0)) {
			
			results = providerRepository.findByCompanyContainsOrIdCompanyContainsAllIgnoreCase(theName, theName);
			
		}
		else {
			
			results = findAll();
			
		}
		
		
		return results;
	}

}
