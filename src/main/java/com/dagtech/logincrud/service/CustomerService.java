package com.dagtech.logincrud.service;

import java.util.List;

import com.dagtech.logincrud.entity.Customer;

public interface CustomerService {
	
	public List<Customer> findAll();
	
	public Customer findById(int id);
	
	public void save(Customer customer);
	
	public void delete(int id);
	
	public List<Customer> searchBy(String theName);

}
