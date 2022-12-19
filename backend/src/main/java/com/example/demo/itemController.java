package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class itemController {
	
	@GetMapping("/api/items")
	public List<String> getItem(){
		
		List<String> items = new ArrayList<>();
		items.add("alpha");
		items.add("beta");
		items.add("gamma");
		
		return items;
	}
	
}
