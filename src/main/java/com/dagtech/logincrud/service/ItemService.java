package com.dagtech.logincrud.service;

import java.util.List;

import com.dagtech.logincrud.entity.Item;

public interface ItemService {
	
	public List<Item> findAll();
	
	public Item findById(int id);
	
	public void save(Item item);
	
	public void delete(int id);
		
}
