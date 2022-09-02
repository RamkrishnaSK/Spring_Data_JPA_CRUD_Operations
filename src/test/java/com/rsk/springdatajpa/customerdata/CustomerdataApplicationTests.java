package com.rsk.springdatajpa.customerdata;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rsk.springdatajpa.customerdata.entities.Customer;
import com.rsk.springdatajpa.customerdata.repos.CustomerRepository;

@SpringBootTest
class CustomerdataApplicationTests {

	@Autowired
	private CustomerRepository repo;

	@Test
	void contextLoads() {
	}

	// Insert Single Record
	@Test
	public void testInsert() {
		Customer customer = new Customer();
		customer.setName("Bharath");
		customer.setEmail("bharatt@gmail.com");
		repo.save(customer);
	}

	// Insert Multiple Records
	@Test
	public void testInsertMultiple() {
		Customer c1 = new Customer();
		c1.setName("KL Rahul");
		c1.setEmail("rahulkl@gmail.com");

		Customer c2 = new Customer();
		c2.setName("Joe Root");
		c2.setEmail("joeroot121@gmail.com");

		Customer c3 = new Customer();
		c3.setName("Williamson");
		c3.setEmail("kanewill@gmail.com");

		List<Customer> list = new ArrayList<>();
		list.add(c1);
		list.add(c2);
		list.add(c3);

		repo.saveAll(list);

	}

	// Fetch all records
	@Test
	public void testFetchAllRecords() {
		System.out.println("Customers Info : ");
		System.out.println("================");
		List<Customer> myList = repo.findAll(); 
		for(Customer c : myList) {
			System.out.println("Id : "+c.getId());
			System.out.println("Name : "+c.getName());
			System.out.println("Email : "+c.getEmail()); 
			System.out.println("----------------------------");
		}
	}
	
	// Delete a Customer
	@Test
	public void testDeleteCustomer() {
		repo.deleteById(3l);   
	}
	
	// Find Customer By Id
	@Test
	public void testFindById() {
		Customer cust = repo.findById(4l).get();
		System.out.println(cust.getId()+" = = = "+cust.getName()+" = = = "+cust.getEmail());
	}
	
	// Update a Customer 
	@Test
	public void testUpdateCustomer() {
		Customer c = repo.findById(2l).get();
		c.setName("Virat Kohli"); 
		c.setEmail("virat900@gmail.com");  
		repo.save(c);
	}

}
