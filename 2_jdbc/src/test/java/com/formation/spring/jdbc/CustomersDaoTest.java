package com.formation.spring.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.spring.dao.CustomersDao;

import junit.framework.TestCase;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
//public class CustomersDaoTest extends TestCase {
public class CustomersDaoTest {
	//ApplicationContext context;
	@Autowired
	CustomersDao custdao;
	
	//public void setUp() {
		//context = new ClassPathXmlApplicationContext("application-context.xml");
		//custdao = (CustomersDao) context.getBean("customersDao");
    //}
	@Test
	public void testInsertTestData() {
		custdao.insertTestData();
		
	}
	@Test
	public void testGetCustomerNames() {
		//custdao = (CustomersDao) context.getBean("customersDao");
		System.out.println("customers names : " + custdao.getCustomerNames());
	}
	
	@Test
	public void testGetCustomers() {
		//custdao = (CustomersDao) context.getBean("customersDao");
		System.out.println("customers NPT: " + custdao.getCustomers());
	}
	
	@Test
	public void testSearchCustomers() {
		//custdao = (CustomersDao) context.getBean("customersDao");
		System.out.println("customers found : " + custdao.searchCustomers("o"));
	}

}
