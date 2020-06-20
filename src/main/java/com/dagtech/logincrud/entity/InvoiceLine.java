package com.dagtech.logincrud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="invoice_line")
public class InvoiceLine {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="unit_price")
	private double unitPrice;
	
	@Column(name="net_price")
	private double netPrice;
	
	@Column(name="invoice_number")
	private Integer invoiceNumber;
	
	public InvoiceLine() {
		
	}

	public InvoiceLine(int id, String description, int quantity, 
			           double unitPrice, double netPrice, int invoiceNumber) {
		this.id = id;
		this.description = description;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.netPrice = netPrice;
		this.invoiceNumber = invoiceNumber;
	}

	public InvoiceLine(String description, int quantity, double unitPrice, 
			           double netPrice, int invoiceNumber) {
		this.description = description;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.netPrice = netPrice;
		this.invoiceNumber = invoiceNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getNetPrice() {
		return netPrice;
	}

	public void setNetPrice(double netPrice) {
		this.netPrice = netPrice;
	}

	public Integer getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(Integer invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	@Override
	public String toString() {
		return "InvoiceLine [id=" + id + ", description=" + description + ", quantity=" + quantity + ", unitPrice="
				+ unitPrice + ", netPrice=" + netPrice + ", invoiceNumber=" + invoiceNumber + "]";
	}
}
