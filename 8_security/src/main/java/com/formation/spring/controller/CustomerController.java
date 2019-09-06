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
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping("/create")
	String create(@ModelAttribute("customer") Customer customer, Model model) {
		return "customer/create";		
	}
	
	@ResponseBody
	@RequestMapping(value="/restlist", method=RequestMethod.GET)
	ResponseEntity<List<Customer>> restCustomers(Model model, HttpServletRequest request) {
		model.addAttribute("customers", customerService.listCustomers());
		
		CacheControl cacheControl = CacheControl.maxAge(300, TimeUnit.SECONDS);
		
		return ResponseEntity.ok().cacheControl(cacheControl).body(customerService.listCustomers());
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	String save(@ModelAttribute("customer") Customer customer, Model model) {
		customerService.add(customer);
		
		model.addAttribute("msg", "Client ajouté");
		model.addAttribute("customers", customerService.listCustomers());
		return "customer/list";		
	}
	
	
	
//	@ResponseBody
//	@RequestMapping(value="/restcreate", method=RequestMethod.POST)
//	List<Customer> createCustomer(Model model, HttpServletRequest request) {
//		model.addAttribute("customers", customerService.add(customer);());
//		return customerService.listCustomers();
//	}
	
}