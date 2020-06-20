package com.dagtech.logincrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dagtech.logincrud.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer>{

}
