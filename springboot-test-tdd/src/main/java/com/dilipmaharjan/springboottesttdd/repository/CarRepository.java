package com.dilipmaharjan.springboottesttdd.repository;

import org.springframework.data.repository.CrudRepository;

import com.dilipmaharjan.springboottesttdd.domain.Car;

public interface CarRepository extends CrudRepository<Car, Long> {
	Car findByName(String carName);
}
