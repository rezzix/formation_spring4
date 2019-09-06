package com.formation.spring.dao;

import java.util.List;

import com.formation.spring.domain.Customer;
import com.formation.spring.domain.Sale;

public interface CustomerDao {
	public void add(Customer customer);
	
	public void add(Customer customer, Sale sale);

	public List<Customer> listCustomers();
}
