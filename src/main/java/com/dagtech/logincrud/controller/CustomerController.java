package com.dagtech.logincrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dagtech.logincrud.entity.Customer;
import com.dagtech.logincrud.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService cService) {
		customerService = cService;
	}
	
	@GetMapping("/showCustomers")
	public String showCustomers(Model model) {
		
		// display a customer list
		List<Customer> customers = customerService.findAll();
				
		model.addAttribute("customers", customers);
				
		return "/customers/customer-list";
	}
	
	@GetMapping("/customerForm")
	public String showCustomerForm(Model model) {
		
		// display a customer form
        Customer customer = new Customer();
		
		model.addAttribute("customer", customer);
		
		return "/customers/customer-form";	
	}
	
	@GetMapping("/updateCustomer")
	public String updateCustomer(@RequestParam("id") int id, Model model) {
		
		// update a customer on the list
		Customer customer = customerService.findById(id);
				
		model.addAttribute("customer", customer);
				
		return "/customers/customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		// save a customer created in the form
	    customerService.save(theCustomer);
		
		return "redirect:/customers/showCustomers";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("id") int id) {
		
		// delete a customer from the list
	    customerService.delete(id);
		
		return "redirect:/customers/showCustomers";
	}
	
	@GetMapping("/searchCustomer")
	public String searchCustomer(@RequestParam("searchName") String searchName, 
			Model model) {
		
		// search the customer by last name or company
		List<Customer> customers = customerService.searchBy(searchName);
		
		model.addAttribute("customers", customers);
		
		return "/customers/customer-list";
		
	}

}
