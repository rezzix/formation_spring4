package com.formation.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.spring.domain.Customer;
import com.formation.spring.dto.Bienvenue;
import com.formation.spring.service.CustomerService;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

//@RestController
@Controller
@RequestMapping("/customer")
public class CustomerController {
	private static final Logger logger = Logger.getLogger(CustomerController.class);
	private static final String TEMPLATE = "Hello, %s!";
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/list")
	String listCustomers(Model model, HttpServletRequest request) {
		model.addAttribute("customers", customerService.listCustomers());
		return "customer/list";
	}
	
	@RequestMapping("/restlist")
	List<Customer> restCustomers(Model model, HttpServletRequest request) {
		model.addAttribute("customers", customerService.listCustomers());
		return customerService.listCustomers();
	}
	
	@ResponseBody
	@RequestMapping("/bienvenue")
	public HttpEntity<Bienvenue> accueil(Model model, HttpServletRequest request, @RequestParam(value = "name", required = false, defaultValue = "World") String name) {

		Bienvenue bienvenue = new Bienvenue(String.format(TEMPLATE, name));
		bienvenue.add(linkTo(methodOn(CustomerController.class).accueil(model, request, name)).withSelfRel());
		bienvenue.add(linkTo(methodOn(CustomerController.class).restCustomers(model, request)).withRel("liste"));

		return new ResponseEntity<Bienvenue>(bienvenue, HttpStatus.OK);
	}
}