package com.dagtech.logincrud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="unit_price")
	private double unitPrice;
	
	public Item() {
		
	}

	public Item(int id, String description, double unitPrice) {
		this.id = id;
		this.description = description;
		this.unitPrice = unitPrice;
	}

	public Item(String description, double unitPrice) {
		this.description = description;
		this.unitPrice = unitPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", description=" + description + ", unitPrice=" + unitPrice + "]";
	}
	
	
	
	

}
