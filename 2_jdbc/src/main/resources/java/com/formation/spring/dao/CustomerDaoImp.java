package com.formation.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.formation.spring.controller.CustomerController;
import com.formation.spring.domain.Customer;

@Service
@Repository
public class CustomerDaoImp implements CustomerDao {
	private static final Logger logger = Logger.getLogger(CustomerDaoImp.class);
	@PersistenceContext
	private EntityManager em;

	public void add(Customer customer) {
		em.persist(customer);
	}
	
	@Cacheable("customers")
	public List<Customer> listCustomers() {
		CriteriaQuery<Customer> criteriaQuery = em.getCriteriaBuilder().createQuery(Customer.class);
		@SuppressWarnings("unused")
		Root<Customer> root = criteriaQuery.from(Customer.class);
		logger.info("DB request executed");
		return em.createQuery(criteriaQuery).getResultList();
	}

}