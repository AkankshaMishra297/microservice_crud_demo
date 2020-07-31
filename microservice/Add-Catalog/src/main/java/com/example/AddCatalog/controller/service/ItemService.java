package com.example.AddCatalog.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ItemService {
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;

	public String addItem(String dashboardRequest) {
		
		RestTemplate rs = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> entity = new HttpEntity<String>(dashboardRequest , headers);
		ServiceInstance instance = loadBalancerClient.choose("View-Catalog");
		
		String url = instance.getUri().toString().concat("/").concat("viewItem");
		
		return rs.exchange(url,HttpMethod.POST,entity,String.class).getBody();
	}

}
