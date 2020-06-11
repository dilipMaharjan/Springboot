package com.dilipmaharjan.aop.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dilipmaharjan.aop.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	List<Customer> findAll();
}
