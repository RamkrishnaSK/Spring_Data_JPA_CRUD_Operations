package com.rsk.springdatajpa.customerdata.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsk.springdatajpa.customerdata.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
