package com.formation.spring.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomersRowMapper implements RowMapper
{
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setId(rs.getInt("id"));
		customer.setFirstName(rs.getString("firstname"));
		customer.setLastName(rs.getString("lastname"));
		return customer;
	}

}