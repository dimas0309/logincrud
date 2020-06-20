package com.dagtech.logincrud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="provider")
public class Provider {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="company")
	private String company;
	
	@Column(name="id_company")
	private String idCompany;
	
	@Column(name="address")
	private String address;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="email")
	private String email;
	
	public Provider() {
		
	}

	public Provider(int id, String company, String idCompany, String address, String phoneNumber, String email) {
		this.id = id;
		this.company = company;
		this.idCompany = idCompany;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public Provider(String company, String idCompany, String address, String phoneNumber, String email) {
		this.company = company;
		this.idCompany = idCompany;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(String idCompany) {
		this.idCompany = idCompany;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Provider [id=" + id + ", company=" + company + ", idCompany=" + idCompany + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}
	
	

}
