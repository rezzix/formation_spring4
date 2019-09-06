package com.formation.spring.util;

// This class is kept intentionally out of spring context to show 
// how important is to keep a standard implementation for songletons

public class Rates {
	static double euroDollars = 1.2;
	static double euroPounds = 0.9;
	static double euroYens = 130;
	
	static public double getEuroDollars() {
		return euroDollars;
	}
	static public void setEuroDollars(double euroDollars) {
		Rates.euroDollars = euroDollars;
	}
	static public double getEuroPounds() {
		return euroPounds;
	}
	static public void setEuroPounds(double euroPounds) {
		Rates.euroPounds = euroPounds;
	}
	static public double getEuroYens() {
		return euroYens;
	}
	static public void setEuroYens(double euroYens) {
		Rates.euroYens = euroYens;
	}

}