package com.dagtech.logincrud.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dagtech.logincrud.entity.Invoice;
import com.dagtech.logincrud.entity.InvoiceLine;
import com.dagtech.logincrud.entity.Item;
import com.dagtech.logincrud.service.InvoiceLineService;
import com.dagtech.logincrud.service.InvoiceService;
import com.dagtech.logincrud.service.ItemService;

@Controller
@RequestMapping("/invoiceLine")
public class InvoiceLineController {
	
	private ItemService itemService;
	private InvoiceLineService invoiceLineService;
	private InvoiceService invoiceService;
	 
	@Autowired
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@Autowired
	public void setInvoiceLineService(InvoiceLineService invoiceLineService) {
		this.invoiceLineService = invoiceLineService;
	}
	
	@Autowired
	public void setinvoiceService(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}
	 
	@GetMapping("/invoiceItem")
	public String invoiceItem(Model model) {
		
		InvoiceLine invoiceLine = new InvoiceLine();
		
		
		List<Item> items = itemService.findAll();
		
		model.addAttribute("items", items);
		model.addAttribute("invoiceLine", invoiceLine);
		
		
		return "/invoice/invoice-line";
	}
	
	@PostMapping("/saveInvoiceLine")
	public String saveInvoiceLine(@ModelAttribute("invoiceLine") InvoiceLine invoiceLine) {
		
		invoiceLineService.save(invoiceLine);
		
		return "redirect:/invoiceLine/showInvoiceLine";
	}
	
	@GetMapping("/showInvoiceLine")
	public String showInvoiceLine(Integer invoiceNumber, Model model) {
		
		//List<InvoiceLine> invoiceLineList = invoiceLineService.findAll();
		List<InvoiceLine> invoiceLineList = invoiceLineService.findByInvoiceNumber(invoiceNumber);
		List<Invoice> invoiceList = invoiceService.findAll();
		Invoice invoice = new Invoice();
		Integer number = invoiceList.size() + 1;
		
		model.addAttribute("number", number);
		model.addAttribute("invoiceLineList", invoiceLineList);
		model.addAttribute("invoice", invoice);
		
		return "/invoice/invoice-line-list";
	} 
}
