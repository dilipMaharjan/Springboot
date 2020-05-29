package com.dilipmaharjan.springboottesttdd.respository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.dilipmaharjan.springboottesttdd.domain.Car;
import com.dilipmaharjan.springboottesttdd.repository.CarRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {
	@Autowired
	private CarRepository carRepository;

	@Autowired
	TestEntityManager entityManager;

	@Test
	public void getCar_returnsCarDetails() {
		Car carObj = new Car();
		carObj.setName("prius");
		carObj.setType("hybrid");
		Car saveCar = entityManager.persistFlushFind(carObj);
		Car car = carRepository.findByName("prius");

		assertThat(car.getName()).isEqualTo(saveCar.getName());
	}
}
