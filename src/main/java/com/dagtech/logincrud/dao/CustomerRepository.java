package com.dagtech.logincrud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dagtech.logincrud.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	// add a method to sort by last name
	public List<Customer> findAllByOrderByLastNameAsc();
	
	// search by last name or company
	public List<Customer> findByLastNameContainsOrCompanyContainsAllIgnoreCase(String lname, String company );
	

}
