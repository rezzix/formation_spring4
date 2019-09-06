package com.formation.spring.cxf;

import javax.jws.WebService;

@WebService(endpointInterface = "com.formation.spring.cxf.TestWs")
	public class TestWsImpl implements TestWs {
	    private int counter;
	 
	    public String hello(String name) {
	        return "Hello " + name + "!";
	    }
	 
	    /*public String register(Student student) {
	        counter++;
	        return student.getName() + " is registered student number " + counter;
	    }*/
	}