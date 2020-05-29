package com.dilipmaharjan.springboottesttdd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dilipmaharjan.springboottesttdd.domain.Car;
import com.dilipmaharjan.springboottesttdd.exception.CarNotFoundException;
import com.dilipmaharjan.springboottesttdd.repository.CarRepository;

@Service
public class CarService {
	@Autowired
	CarRepository carRepository;

	public Car getCarDetails(String carName) {
		Car car = carRepository.findByName(carName);
		if (car == null) {
			throw new CarNotFoundException();
		}
		return car;
	}
}
