package com.formation.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.formation.spring.domain.Customer;
import com.formation.spring.domain.Sale;

@Service
@Repository
public class CustomerDaoImp implements CustomerDao {

	@PersistenceContext
	private EntityManager em;

	public void add(Customer customer) {
		em.persist(customer);
	}
	
	public void add(Customer customer, Sale sale) {
		em.persist(customer);
		sale.setCustomer(customer);
		System.out.println(1/0);
		em.persist(sale);
	}

	public List<Customer> listCustomers() {
		CriteriaQuery<Customer> criteriaQuery = em.getCriteriaBuilder().createQuery(Customer.class);
		@SuppressWarnings("unused")
		Root<Customer> root = criteriaQuery.from(Customer.class);
		//criteriaQuery.where();
		return em.createQuery(criteriaQuery).getResultList();
	}

}