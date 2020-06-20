package com.dagtech.logincrud.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dagtech.logincrud.dao.InvoiceLineRepository;
import com.dagtech.logincrud.entity.InvoiceLine;

@Service
public class InvoiceLineServiceImpl implements InvoiceLineService {
	
	private InvoiceLineRepository invoiceLineRepository;
	
	@Autowired
	public InvoiceLineServiceImpl(InvoiceLineRepository ilRepository) {
		invoiceLineRepository = ilRepository;
	}

	@Override
	public List<InvoiceLine> findAll() {
		
		// TODO Auto-generated method stub
		return invoiceLineRepository.findAll();
	}

	@Override
	public InvoiceLine findById(int id) {
		
		// TODO Auto-generated method stub
		Optional <InvoiceLine> result = invoiceLineRepository.findById(id);
		
	    InvoiceLine invoiceLine = null;
				
		if(result.isPresent()) {
		  invoiceLine = result.get();
		}
		else {
		  throw new RuntimeException("Did not find invoiceLine id - " + id);
		}
		return invoiceLine;
	}

	@Override
	public void save(InvoiceLine invoiceLine) {
		
		// TODO Auto-generated method stub
		invoiceLineRepository.save(invoiceLine);
	}

	@Override
	public void delete(int id) {
		
		// TODO Auto-generated method stub
		invoiceLineRepository.deleteById(id);
	}

	@Override
	public List<InvoiceLine> findByInvoiceNumber(Integer invoiceNumber) {
		
		// TODO Auto-generated method stub
		return invoiceLineRepository.findByInvoiceNumber(invoiceNumber);
	}
}
