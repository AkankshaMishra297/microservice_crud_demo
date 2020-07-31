package com.example.ViewCatalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ViewCatalog.model.Item;
import com.example.ViewCatalog.repository.ItemRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ViewService {
	
	private static final ObjectMapper om = new ObjectMapper();

	@Autowired
	private ItemRepository itemRepo;
	
	public String viewItem(String dashboardRequest) throws Exception {
		
		JsonNode js = om.readTree(dashboardRequest);
		
		String name = js.get("name").asText();
		
		Item i = new Item();
		i.setName(name);
		
		this.itemRepo.save(i);
		
		String response = om.writeValueAsString(this.itemRepo.findAll());
		
		return response;
	
	}

}
