package com.dilipmaharjan.springboottesttdd.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.dilipmaharjan.springboottesttdd.domain.Car;
import com.dilipmaharjan.springboottesttdd.exception.CarNotFoundException;
import com.dilipmaharjan.springboottesttdd.service.CarService;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
public class CarControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CarService carService;

	@Test
	public void getCar_shouldReturnCar() throws Exception {

		// when(carService.getCarDetails(anyString())).thenReturn(new Car(1l, "prius",
		// "hybrid"));
		given(carService.getCarDetails("prius")).willReturn(new Car(1l, "prius", "hybrid"));

		mockMvc.perform(MockMvcRequestBuilders.get("/cars/prius")).andExpect(status().isOk())
				.andExpect(jsonPath("name").value("prius")).andExpect(jsonPath("type").value("hybrid"));
	}

	@Test
	public void getCar_notFound() throws Exception {

		given(carService.getCarDetails(anyString())).willThrow(new CarNotFoundException());

		mockMvc.perform(MockMvcRequestBuilders.get("/cars/prius")).andExpect(status().isNotFound());
	}
}
