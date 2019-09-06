package com.formation.spring.coretests;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.spring.service.CurrecyConverter;
import com.formation.spring.util.Config;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        //System.out.println( "Hello World!" );
    	ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
    	
    	Config config = (Config) context.getBean("appConfig");
    	
    	CurrecyConverter currecyConverter = (CurrecyConverter) context.getBean("currecyConverter");
    	
    	currecyConverter.updateRates();
    	Thread.sleep(10000);
    	System.out.println("Fin");
    }
}
