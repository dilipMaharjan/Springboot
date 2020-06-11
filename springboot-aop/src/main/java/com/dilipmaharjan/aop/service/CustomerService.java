package com.dilipmaharjan.aop.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dilipmaharjan.aop.dto.CustomerDTO;
import com.dilipmaharjan.aop.entity.Customer;
import com.dilipmaharjan.aop.repository.CustomerRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public List<CustomerDTO> getCustomers() {
		ObjectMapper mapper = new ObjectMapper();
		List<CustomerDTO> customersDTO = new ArrayList<>();
		customersDTO = mapper.convertValue(customerRepository.findAll(),
				new TypeReference<List<CustomerDTO>>() {
				});
		return customersDTO;
	}

	public CustomerDTO getCustomer(Long id) {
		ObjectMapper mapper = new ObjectMapper();
		CustomerDTO customer = new CustomerDTO();
		mapper.convertValue(customerRepository.findById(id).get(), new TypeReference<Customer>() {
		});
		return customer;
	}
}
