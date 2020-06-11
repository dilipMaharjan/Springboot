package com.dilipmaharjan.springdatajpa.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dilipmaharjan.springdatajpa.entity.Todo;
import com.dilipmaharjan.springdatajpa.service.TodoService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/todos")
@Slf4j
public class TodoController {
	@Autowired
	private TodoService todoService;

	@GetMapping
	public List<Todo> todos() {
		log.info("Find all requested.");
		return todoService.findAll();
	}

	@GetMapping("/{id}")
	public Todo todo(@PathVariable Integer id) {
		return todoService.findBy(id);
	}

	@PatchMapping
	public Todo updateTodo(@RequestBody Todo todo) throws Exception {
		if (null == todo.getId()) {
			throw new Exception("Id  must not be null");
		}
		return todoService.update(todo);
	}

	@PostMapping
	public Todo create(@RequestBody Todo todo) throws Exception {
		if (null != todo.getId()) {
			throw new Exception("Id  must be null");
		}
		return todoService.create(todo);
	}

	@GetMapping("/title")
	public Todo findBy(@RequestParam(name = "title") String title) throws Exception {
		if (null == title) {
			throw new Exception("Title  must not  be null");
		}
		return todoService.findBy(title);
	}

	@GetMapping("/createdon")
	public List<Todo> findBycreatedOnLessThanEqual(@RequestParam(name = "createdon") Date createdon) throws Exception {
		if (null == createdon) {
			throw new Exception("Createdon  must not  be null");
		}
		return todoService.findBycreatedOnLessThanEqual(createdon);
	}
}
