package com.example.ViewCatalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ViewCatalog.service.ViewService;


@RestController
public class ViewController {
	
	@Autowired
	private ViewService viewService;
	
	@PostMapping(value = "/viewItem", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addUser(@RequestBody String dashboardRequest) throws Exception {
		ResponseEntity<?> responseEntity = null;
			String jsonString = viewService.viewItem(dashboardRequest);
			if(jsonString != null){
				responseEntity = ResponseEntity.ok(jsonString);
			} else
				responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		return responseEntity;
	}

}
