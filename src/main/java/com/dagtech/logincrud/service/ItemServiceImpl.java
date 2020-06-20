package com.dagtech.logincrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dagtech.logincrud.dao.ItemRepository;
import com.dagtech.logincrud.entity.Item;

@Service
public class ItemServiceImpl implements ItemService {
	
	private ItemRepository itemRepository;
	
	@Autowired
	public ItemServiceImpl(ItemRepository iRepository) {
		itemRepository = iRepository;
	}

	@Override
	public List<Item> findAll() {
		
		// method to retrieve all items
		return itemRepository.findAll();
	}

	@Override
	public Item findById(int id) {
		
		// method to retrieve an item by id
		Optional <Item> result = itemRepository.findById(id);
				
	    Item item = null;
				
		if(result.isPresent()) {
		  item = result.get();
		}
		else {
		  throw new RuntimeException("Did not find item id - " + id);
		}
				
		return item;
	}

	@Override
	public void save(Item item) {
		
		// method to save an item
		itemRepository.save(item);
	}

	@Override
	public void delete(int id) {
		
		// method to delete an item
		itemRepository.deleteById(id);;
	}

	 
}
