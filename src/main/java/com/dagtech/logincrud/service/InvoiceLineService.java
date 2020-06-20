package com.dagtech.logincrud.service;

import java.util.List;
import com.dagtech.logincrud.entity.InvoiceLine;

public interface InvoiceLineService {
	
	List <InvoiceLine> findAll();
	
	public InvoiceLine findById(int id);
	
	public void save(InvoiceLine invoiceLine);
	
	public void delete(int id);
	
	List<InvoiceLine> findByInvoiceNumber(Integer invoiceNumber);
}
