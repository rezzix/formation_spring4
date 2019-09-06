package com.formation.spring.batch;

import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<Transaction, Transaction> {
	 
    public Transaction process(Transaction item) {
    	if (item.getAmount()>10000)
    		item.setUsername("secret");
        return item;
    }
}
