package com.dagtech.logincrud.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dagtech.logincrud.entity.InvoiceLine;

public interface InvoiceLineRepository extends JpaRepository<InvoiceLine, Integer> {
	
	@Query("FROM InvoiceLine WHERE invoiceNumber >= 1")
	List<InvoiceLine> findByInvoiceNumber(Integer invoiceNumber);	
}
