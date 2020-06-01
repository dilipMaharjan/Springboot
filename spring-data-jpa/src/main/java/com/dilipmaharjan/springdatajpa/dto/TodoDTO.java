package com.dilipmaharjan.springdatajpa.dto;

import lombok.Data;

@Data
public class TodoDTO {

	private String id;
	private String title;
	private String description;
	private String todoStatus;
	private String createdOn;
	private String updatedOn;

}
