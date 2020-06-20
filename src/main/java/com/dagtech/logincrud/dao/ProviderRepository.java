package com.dagtech.logincrud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dagtech.logincrud.entity.Provider;

public interface ProviderRepository extends JpaRepository<Provider, Integer> {
	
	// add a method to sort by company
	public List<Provider> findAllByOrderByCompanyAsc();
	
	// search by name
	public List<Provider> findByCompanyContainsOrIdCompanyContainsAllIgnoreCase(
			                           String company, String idCompany);


}
