package com.formation.spring.util;

// This class is kept intentionally out of spring context to show 
// how important is to keep a standard implementation for songletons

public class Rates {
	//private static Rates ratesInstance;

	double euroDollars = 1.2;
	double euroPounds = 0.9;
	double euroYens = 130;

	
//	public static Rates getInstance() {
//		if (ratesInstance == null) {
//			synchronized (Rates.class) {
//				ratesInstance = new Rates();
//			}
//		}
//		return ratesInstance;
//	}

//	// interdire l'instantiation
//	private Rates() {
//		//
//	}

	public double getEuroDollars() {
		return euroDollars;
	}

	public void setEuroDollars(double euroDollars) {
		this.euroDollars = euroDollars;
	}

	public double getEuroPounds() {
		return euroPounds;
	}

	public void setEuroPounds(double euroPounds) {
		this.euroPounds = euroPounds;
	}

	public double getEuroYens() {
		return euroYens;
	}

	public void setEuroYens(double euroYens) {
		this.euroYens = euroYens;
	}

}