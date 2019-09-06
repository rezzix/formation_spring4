package com.formation.spring.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.formation.spring.domain.Customer;
import com.formation.spring.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	private static final Logger logger = Logger.getLogger(CustomerController.class);
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/list")
	String listCustomers(Model model, HttpServletRequest request) {
		logger.info("listCustomers called");
		model.addAttribute("customers", customerService.listCustomers());
		logger.info("returning : " + customerService.listCustomers());
		return "customer/list";
	}
	
	@RequestMapping("/create")
	String create(@ModelAttribute("customer") Customer customer, Model model) {
		return "customer/create";		
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	String save(@ModelAttribute("customer") @Valid Customer customer, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "customer/create";
	    }
		
		customerService.add(customer);
		
		model.addAttribute("msg", "Client ajouté");
		model.addAttribute("customers", customerService.listCustomers());
		return "customer/list";		
	}
	
}