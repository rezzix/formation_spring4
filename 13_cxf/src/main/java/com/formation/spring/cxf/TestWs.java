package com.formation.spring.cxf;

import javax.jws.WebService;

@WebService
public interface TestWs {
	String hello(String name);
}
