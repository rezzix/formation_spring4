package com.formation.spring.jmx;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
//public class CustomersDaoTest extends TestCase {
public class JmxTest {
	//ApplicationContext context;
	
	//public void setUp() {
		//context = new ClassPathXmlApplicationContext("application-context.xml");
		//custdao = (CustomersDao) context.getBean("customersDao");
    //}
	
	@Autowired
	IJmxTestBean testBean;
	@Test
	public void testJmx() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(testBean.getName());
		}
	}

}
