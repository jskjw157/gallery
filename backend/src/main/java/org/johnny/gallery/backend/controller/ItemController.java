package org.johnny.gallery.backend.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.johnny.gallery.backend.entity.Item;
import org.johnny.gallery.backend.entity.Test;
import org.johnny.gallery.backend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
	
	@Autowired
	ItemRepository itemRepository;
	
	@GetMapping("/api/items")
	public List<Item> getItems(){
		List<Item> items = itemRepository.findAll();
		String stringList = items.toString();
		System.out.println("hihi"+stringList);
		
		return items;
	}
	
	@GetMapping("/api/test")
	public List<Test> getTest(){
		
		Test test1 = new Test(10,"sdf");
		Test test2 = new Test(20,"dsdf");
		List<Test> test = new ArrayList<>(Arrays.asList(test1, test2));
		
		System.out.println("test12"+test);
		return test;
	}
	
}
