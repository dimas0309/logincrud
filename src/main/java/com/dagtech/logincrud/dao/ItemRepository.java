package com.dagtech.logincrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dagtech.logincrud.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
