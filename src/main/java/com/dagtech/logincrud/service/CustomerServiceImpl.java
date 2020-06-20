package com.dagtech.logincrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dagtech.logincrud.dao.CustomerRepository;
import com.dagtech.logincrud.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository cRepository) {
		customerRepository = cRepository;
	}

	@Override
	public List<Customer> findAll() {
		
		// method to retrieve all customer by last name.
		return customerRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Customer findById(int id) {
		
		// method to retrieve a customer by id
        Optional <Customer> result = customerRepository.findById(id);
		
		Customer customer = null;
		
		if(result.isPresent()) {
			customer = result.get();
		}
		else {
			throw new RuntimeException("Did not find customer id - " + id);
		}
		
		return customer;
	}

	@Override
	public void save(Customer customer) {
		
		// method to save a customer
	    customerRepository.save(customer);
		
	}

	@Override
	public void delete(int id) {
		
		// method to delete a customer
        customerRepository.deleteById(id);
		
	}

	@Override
	public List<Customer> searchBy(String theName) {
		
		// method to search a customer by last name or company
		List<Customer> results = null;
		
		if (theName != null && (theName.trim().length() > 0)) {
			results = customerRepository.findByLastNameContainsOrCompanyContainsAllIgnoreCase(theName, theName);
		}
		else {
			results = findAll();
		}
		
		return results;
	}

}
