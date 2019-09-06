package com.formation.spring.restclient;

import java.io.IOException;
import java.util.Set;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.formation.spring.domain.Customer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws JsonProcessingException, IOException
    {
    	RestTemplate restTemplate = new RestTemplate();
    	String resourceUrl = "http://localhost:4080/5_rest/customer/restlist.json";
    	
    	
    	HttpHeaders httpHeaders = restTemplate.headForHeaders(resourceUrl);
    	
    	System.out.println(httpHeaders);
    	
    	Set<HttpMethod> optionsForAllow = restTemplate.optionsForAllow(resourceUrl);
    	
    	System.out.println(optionsForAllow);
    	
  
    	ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl , String.class);
    	System.out.println(response);
    	
    	
    	Customer[] custs = restTemplate.getForObject(resourceUrl , Customer[].class);
    	
    	for (Customer c : custs)
    		System.out.println(c);
    	
    	resourceUrl = "http://localhost:4080/4_web/customer/restlist.json";
    }
}
