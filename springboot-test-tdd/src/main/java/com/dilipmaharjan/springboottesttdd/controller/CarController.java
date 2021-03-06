package com.dilipmaharjan.springboottesttdd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dilipmaharjan.springboottesttdd.domain.Car;
import com.dilipmaharjan.springboottesttdd.service.CarService;

@RestController
public class CarController {

	@Autowired
	private CarService carService;

	@GetMapping("/cars/{name}")
	public Car getCar(@PathVariable String name) {
		return carService.getCarDetails(name);
	}
}
