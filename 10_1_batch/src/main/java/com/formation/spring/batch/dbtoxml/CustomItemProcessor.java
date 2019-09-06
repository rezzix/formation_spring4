package com.formation.spring.batch.dbtoxml;

import org.springframework.batch.item.ItemProcessor;

import com.formation.spring.domain.Customer;

public class CustomItemProcessor implements ItemProcessor<Customer, Customer> {
	 
    public Customer process(Customer item) {
        return item;
    }
}
