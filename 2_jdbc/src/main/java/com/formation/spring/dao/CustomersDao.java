package com.formation.spring.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.formation.spring.domain.Customer;
import com.formation.spring.domain.CustomersRowMapper;

@Repository
public class CustomersDao {
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate npJdbcTemplate;
	private SimpleJdbcInsert insertTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.npJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.insertTemplate = new SimpleJdbcInsert(dataSource).withTableName("customers");
	}
	
	public void insertTestData() {
		//this.jdbcTemplate.update( "insert into customers (first_name, last_name) values (?, ?)", "Leonor", "Watling");
		
		
		HashMap<String, Object> parameters = new HashMap<String, Object>(3);
        //parameters.put("id", actor.getId());
        parameters.put("first_name", "colin");
        parameters.put("last_name", "feron");
		
        this.insertTemplate.execute(parameters);
	}
	
	public List<String> getCustomerNames() {
		List ret = new ArrayList<String>();
		List<Map<String, Object>> rows = this.jdbcTemplate.queryForList("select first_name from customers");
		for (Map row : rows) {
			ret.add(row.get("first_name"));
		}
		
		return ret;
	}
	
	public List<Customer> getCustomers() {
		return jdbcTemplate.query("select * from customers",new CustomersRowMapper());
	}
	
	public List<Customer> searchCustomers(String namepart) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("first_name", "%"+namepart+"%");
		return this.npJdbcTemplate.query("select * from customers where first_name like '%o%'", params,new CustomersRowMapper());
	}

}
