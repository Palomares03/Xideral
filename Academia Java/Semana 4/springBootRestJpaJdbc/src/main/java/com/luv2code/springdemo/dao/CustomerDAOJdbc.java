package com.luv2code.springdemo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOJdbc implements CustomerDAO {

	@Autowired
	DataSource dataSource;

	@Override
	public List<Customer> getCustomers() {

		System.out.println("PASO POR CustomerDAOJdbc");
		List<Customer> customers = new ArrayList<>();

		// create sql statement
		String sql = "select * from customer order by last_name";

		try (Connection myConn = dataSource.getConnection();
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery(sql)) {

			// process result set
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");

				// create new student object
				Customer tempCustomer = new Customer(id, firstName, lastName, email);

				// add it to the list of students
				customers.add(tempCustomer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;

	}

	@Override
	public Customer saveCustomer(Customer theCustomer) {
		
		String sql = null;
		if(theCustomer.getId() == 0)
			sql = "insert into customer " + "(first_name, last_name, email) " + "values (?, ?, ?)";
		else
			sql = "update customer " + "set first_name=?, last_name=?, email=? " + "where id=?";

		try (Connection myConn = dataSource.getConnection(); 
			PreparedStatement ps = myConn.prepareStatement(sql)) {

			ps.setString(1, theCustomer.getFirstName());
			ps.setString(2, theCustomer.getLastName());
			ps.setString(3, theCustomer.getEmail());
			
			//id para where del update
			if(theCustomer.getId() != 0)
				ps.setInt(4, theCustomer.getId());

			ps.execute();
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		return theCustomer;

	}

	@Override
	public Customer getCustomer(int theId) {
		Customer theCustomer = null;

		try (Connection myConn = dataSource.getConnection();
				PreparedStatement myStmt = crearStatementGetCustomer(myConn, theId);
				ResultSet myRs = myStmt.executeQuery()) {

			// retrieve data from result set row
			if (myRs.next()) {
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");

				// use the studentId during construction
				theCustomer = new Customer(theId, firstName, lastName, email);
			} else {
				System.out.println("Could not find customer id: " + theId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return theCustomer;
	}

	private PreparedStatement crearStatementGetCustomer(Connection myConn, int customerId) throws SQLException {
		String sql = "select * from student where id=?";
		PreparedStatement ps = myConn.prepareStatement(sql);
		ps.setInt(1, customerId);
		return ps;
	}

	@Override
	public void deleteCustomer(int theId) {

		// create sql to delete student
		String sql = "delete from customer where id=?";

		try (Connection myConn = dataSource.getConnection(); 
				PreparedStatement myStmt = myConn.prepareStatement(sql);) {

			// set params
			myStmt.setInt(1, theId);

			// execute sql statement
			myStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void saveCustomers(Customer theCustomer) {
		// TODO Auto-generated method stub
		
	}

}
