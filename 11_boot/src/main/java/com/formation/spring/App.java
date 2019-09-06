package com.formation.spring;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.spring.domain.Customer;
import com.formation.spring.domain.Sale;
import com.formation.spring.repository.CustomerRepository;

@Controller

@SpringBootApplication
//@EnableAutoConfiguration
//@Configuration
//@ComponentScan({"com.formation.spring"})

@EntityScan("com.formation.spring.domain")
@EnableJpaRepositories("com.formation.spring.repository")

public class App 
{
	@Autowired
    DataSource dataSource;

    @Autowired
    CustomerRepository customerRepository;
    
    @RequestMapping("/")
    String home() {
        return "Simple boot project";
    }
    
    @RequestMapping(value="/restcust",method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> restCustomers() {
    	List<Customer> ret = new ArrayList<Customer>();
    	Customer customer = new Customer(1L,"lime","dolphin");
    	
    	customer.getSales().add(new Sale(1000,"EUR"));
    	customer.getSales().add(new Sale(200,"USD"));
    	ret.add(customer);
    	
        return ret;
    }
    
    @RequestMapping(value="/restcustdb",method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> restCustomersdb() {
    	List<Customer> ret = new ArrayList<Customer>();
    	//System.out.println(customerRepository.findAll());
    	for (Customer cust : customerRepository.findAll())
    		ret.add(cust);
        return ret;
    }
    
    @GetMapping("/bienvenue")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "bienvenue";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }
}
