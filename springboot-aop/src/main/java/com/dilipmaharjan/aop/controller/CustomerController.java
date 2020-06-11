package com.dilipmaharjan.aop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dilipmaharjan.aop.dto.CustomerDTO;
import com.dilipmaharjan.aop.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers")
	public List<CustomerDTO> getCustomers() {
		return customerService.getCustomers();
	}

	@GetMapping("/customers/{id}")
	public CustomerDTO getCustomer(@PathVariable Long id) {
		return customerService.getCustomer(id);
	}
}
