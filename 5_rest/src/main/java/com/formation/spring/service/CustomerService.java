package com.formation.spring.service;

import java.util.List;

import com.formation.spring.domain.Customer;

public interface CustomerService {
    void add(Customer customer);
    List<Customer> listCustomers();
    void deleteCustomer(long id);
}