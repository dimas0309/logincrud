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

import com.dagtech.logincrud.entity.Invoice;
import com.dagtech.logincrud.service.InvoiceService;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {
	
	private InvoiceService invoiceService;
	
	@Autowired
	public InvoiceController(InvoiceService ivService) {
		this.invoiceService = ivService;	
	}
	
	@GetMapping("/totalInvoice")
	public String invoiceItemList(Model model) {
		
		Invoice invoice = new Invoice();
		
		model.addAttribute("invoice", invoice);
		
		return "/invoice/invoice-line-list";
	}
	
	@PostMapping("/saveInvoice")
	public String saveInvoice(@ModelAttribute("invoice") Invoice invoice) {
		
		invoiceService.save(invoice);
		
		return "redirect:/invoice/showInvoice";
	}
	
	@GetMapping("/showInvoice")
	public String showInvoice(Model model) {
		
		List<Invoice> invoices = invoiceService.findAll();
		Integer number = invoices.size();
		
		model.addAttribute("invoices", invoices);
		model.addAttribute("number", number);
		
		return "/invoice/total-invoice";
	}
	
	
	

}
