package com.dilipmaharjan.swagger.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dilipmaharjan.swagger.model.Todo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "Todo controller and documentation")
@RestController
@RequestMapping("/todos")
public class TodoController {
	private ConcurrentHashMap<String, Todo> todos = new ConcurrentHashMap<>();

	@GetMapping
	public List<Todo> getTodos() {
		return new ArrayList<Todo>(todos.values());
	}

	@ApiOperation(value = "Retrieves Todo", httpMethod = "GET", notes = "This is a note")
	@GetMapping("/{id}")
	public Todo getTodo(@PathVariable String id) {
		return todos.get(id);
	}

	@PostMapping
	public Todo addOrUpdateTodo(@RequestBody Todo todo) {
		todos.put(todo.getId(), todo);
		return todo;
	}

}
