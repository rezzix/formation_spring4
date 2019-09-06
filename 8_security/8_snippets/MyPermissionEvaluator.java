package com.formation.spring.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.formation.spring.domain.Customer;

public class MyPermissionEvaluator implements PermissionEvaluator {

	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
		List<String> roles = new ArrayList<String>();
		for (GrantedAuthority r : authentication.getAuthorities()) {
			roles.add(r.getAuthority());
		}
		if (targetDomainObject instanceof Customer) {
			Customer cust = (Customer) targetDomainObject;
			if (cust.getLastName().contains("n") && ! roles.contains("ROLE_ADMIN"))
				return false;
			else
				return true;
		} else {
			return false;
		}
	}

	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
			Object permission) {
		// TODO Auto-generated method stub
		return false;
	}

}
