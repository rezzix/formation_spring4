package com.formation.spring.batch;

import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<Transaction, Transaction> {
	 
    public Transaction process(Transaction item) {
    	//cacher le nom des client ayant fait des transaction > 10000 
        return item;
    }
}
