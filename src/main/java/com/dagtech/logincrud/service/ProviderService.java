package com.dagtech.logincrud.service;

import java.util.List;

import com.dagtech.logincrud.entity.Provider;

public interface ProviderService {
	
	public List<Provider> findAll();
	
	public Provider findById(int id);
	
	public void save(Provider provider);
	
	public void delete(int id);
	
	public List<Provider> searchBy(String theName);
	
	

}
