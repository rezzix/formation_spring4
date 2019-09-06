package com.formation.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.spring.dao.CustomerDao;
import com.formation.spring.domain.Customer;


@Service
public class CustomerServiceImpl implements CustomerService {

   @Autowired
   private CustomerDao customerDao;

   @Transactional
   public void add(Customer customer) {
	   customerDao.add(customer);
   }

   @Transactional(readOnly = true)
   public List<Customer> listCustomers() {
      return customerDao.listCustomers();
   }


}