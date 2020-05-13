package com.dilipmaharjan.swagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Todo Model")
public class Todo {
	@ApiModelProperty(required = true)
	private String id;
	@ApiModelProperty(example = "Todo Title")
	private String title;
	private String description;
}
