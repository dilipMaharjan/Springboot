package com.dilipmaharjan.springboottesttdd.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.BDDMockito.given;
import com.dilipmaharjan.springboottesttdd.domain.Car;
import com.dilipmaharjan.springboottesttdd.exception.CarNotFoundException;
import com.dilipmaharjan.springboottesttdd.repository.CarRepository;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

	@Mock
	private CarRepository carRepository;

	@InjectMocks
	private CarService carService;

	@Test
	public void testGetCarDetails_returnsCarDetail() {
		given(carRepository.findByName("prius")).willReturn(new Car(1l, "prius", "hybrid"));

		Car car = carService.getCarDetails("prius");
		assertThat(car.getName()).isEqualTo("prius");
		assertThat(car.getType()).isEqualTo("hybrid");
	}

	@Test(expected = CarNotFoundException.class)
	public void testGetCarDetails_returnsCarNotFoundException() {
		given(carRepository.findByName("prius")).willReturn(null);
		carService.getCarDetails("prius");
	}

}
