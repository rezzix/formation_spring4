package com.formation.spring.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.spring.domain.Customer;
import com.formation.spring.service.CustomerService;

//@RestController
@Controller
@RequestMapping("/customer")
public class CustomerController {
	private static final Logger logger = Logger.getLogger(CustomerController.class);
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/list")
	String listCustomers(Model model, HttpServletRequest request) {
		model.addAttribute("customers", customerService.listCustomers());
		return "customer/list";
	}
	
	@ResponseBody
	@RequestMapping(value="/restlist", method=RequestMethod.GET)
	ResponseEntity<List<Customer>> restCustomers(Model model, HttpServletRequest request) {
		model.addAttribute("customers", customerService.listCustomers());
		
		CacheControl cacheControl = CacheControl.maxAge(300, TimeUnit.SECONDS);
		
		return ResponseEntity.ok().cacheControl(cacheControl).body(customerService.listCustomers());
	}
	
	
	@ResponseBody
	@RequestMapping(value=("/delete/{id}"), method=RequestMethod.DELETE)
	ResponseEntity deleteCustomer(@PathVariable("id") long id) {
		customerService.deleteCustomer(id);
		return ResponseEntity.ok().body("Customer has been deleted successfully.");
	}
	
}