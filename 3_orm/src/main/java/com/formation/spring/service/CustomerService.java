package com.formation.spring.service;

import java.util.List;

import com.formation.spring.domain.Customer;
import com.formation.spring.domain.Sale;

public interface CustomerService {
    void add(Customer customer);
    void add(Customer customer, Sale sale);
    List<Customer> listCustomers();
}