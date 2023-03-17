package com.luv2code.springdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOJpa implements CustomerDAO {
	
    // define field for entity manager
    private EntityManager entityManager;
    
    // set up constructor injection
    @Autowired
    public CustomerDAOJpa(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


	@Override
	public List<Customer> getCustomers() {
		System.out.println("PASO POR CustomerDAOJpa");
		// create a query
        TypedQuery<Customer> theQuery = entityManager.createQuery("from Customer", Customer.class);

        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();

        // return the results
        return customers;
	}

	@Override
	public Customer saveCustomer(Customer theCustomer) {
		Customer customer = entityManager.merge(theCustomer);
		return customer;
	}

	@Override
	public Customer getCustomer(int theId) {
		Customer theCustomer = entityManager.find(Customer.class, theId);
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		Customer theCustomer = entityManager.find(Customer.class, theId);
        // remove employee
        entityManager.remove(theCustomer);
		
	}


	@Override
	public void saveCustomers(Customer theCustomer) {
		// TODO Auto-generated method stub
		
	}

}
