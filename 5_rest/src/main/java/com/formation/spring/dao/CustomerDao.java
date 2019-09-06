package com.formation.spring.dao;

import java.util.List;

import com.formation.spring.domain.Customer;

public interface CustomerDao {
	public void add(Customer customer);

	public List<Customer> listCustomers();
	
	public void deleteCustomer(long id);
}
