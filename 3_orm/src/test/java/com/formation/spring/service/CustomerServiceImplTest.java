package com.formation.spring.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.spring.domain.Customer;
import com.formation.spring.domain.Sale;

import junit.framework.TestCase;

public class CustomerServiceImplTest extends TestCase {

	ApplicationContext context;
	CustomerService custservice;
	
	protected void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("application-context.xml");
		custservice = (CustomerService) context.getBean("customerServiceImpl");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testAdd() {
		custservice.add(new Customer("roxane", "lanane"));
		custservice.add(new Customer("nick", "godin"), new Sale(120,"EUR"));
	}

	public void testListCustomers() {
		//System.out.println();
		for (Customer customer : custservice.listCustomers()) {
			System.out.println("" + customer + " " + customer.getSales());
		}
	}

}
