package com.dilipmaharjan.aop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CustomerDTO {
	@JsonProperty(value = "id")
	private Long id;
	@JsonProperty(value = "firstName")
	private String firstName;
	@JsonProperty(value = "lastName")
	private String lastName;
	@JsonProperty(value = "email")
	private String email;
	@JsonProperty(value = "extraField")
	private String extraField;
}
