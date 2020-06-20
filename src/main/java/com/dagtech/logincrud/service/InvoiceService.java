package com.dagtech.logincrud.service;

import java.util.List;

import com.dagtech.logincrud.entity.Invoice;

public interface InvoiceService {
	
	public List<Invoice> findAll();
	
	public Invoice findById(Integer id);
	
	public void save(Invoice invoice);
	
	public void delete(Integer id);

}
