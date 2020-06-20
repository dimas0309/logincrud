package com.dagtech.logincrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dagtech.logincrud.dao.InvoiceRepository;
import com.dagtech.logincrud.entity.Invoice;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	
	private InvoiceRepository invoiceRepository;
	
	@Autowired
	public InvoiceServiceImpl(InvoiceRepository ivRepository) {
		invoiceRepository = ivRepository;
	}
	
	
	@Override
	public List<Invoice> findAll() {
		
		// TODO Auto-generated method stub
		return invoiceRepository.findAll();
	}

	@Override
	public Invoice findById(Integer id) {
		
		// TODO Auto-generated method stub
		Optional <Invoice> result = invoiceRepository.findById(id);
		Invoice invoice = null;
		
		if(result.isPresent()) {
			invoice = result.get();
		}
		else {
			throw new RuntimeException("Did not find invoice id -" + id);
		}
		
		return invoice;
	}

	@Override
	public void save(Invoice invoice) {
		
		// TODO Auto-generated method stub
		invoiceRepository.save(invoice);
	}

	@Override
	public void delete(Integer id) {
		
		// TODO Auto-generated method stub
		invoiceRepository.deleteById(id);
	}

}
