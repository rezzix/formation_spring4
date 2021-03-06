package com.formation.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.spring.dao.CustomerDao;
import com.formation.spring.domain.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Transactional
	public void add(Customer customer) {
		customerDao.add(customer);
	}

	@Cacheable("customers")
	@Transactional(readOnly = true)
	public List<Customer> listCustomers() {
		return customerDao.listCustomers();
	}

	@Transactional
	public void deleteCustomer(long id) {
		customerDao.deleteCustomer(id);
	}

}