package com.formation.spring.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

import com.formation.spring.util.Rates;

public class CurrecyConverter {
	
	Rates rates;
	
	double euroToUsd (double euro) {
		return euro * rates.getEuroDollars();
	}
	
	double usdToEuros (double dollar) {
		return dollar / rates.getEuroDollars();
	}
	
	//@Async
	@Scheduled(fixedDelay=1000)
	public void updateRates(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		rates.setEuroDollars(rates.getEuroDollars() + ((Math.random()-0.5) * 0.1) );
		rates.setEuroPounds(rates.getEuroPounds() + ((Math.random()-0.5) * 0.1) );
		rates.setEuroYens(rates.getEuroYens() + ((Math.random()-0.5) * 0.1) );
	}

	public Rates getRates() {
		return rates;
	}

	public void setRates(Rates rates) {
		this.rates = rates;
	}

}
