package com.dilipmaharjan.springdatajpa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dilipmaharjan.springdatajpa.entity.Todo;
import com.dilipmaharjan.springdatajpa.repository.TodoRepository;

@Service
@Transactional
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;

	public List<Todo> findAll() {
		return todoRepository.findAll();
	}

	public Todo findBy(Integer id) {
		return todoRepository.findById(id).get();
	}

	public Todo update(Todo todo) {
		return todoRepository.save(todo);
	}

	public Todo create(Todo todo) {
		todoRepository.save(todo);
		return todo;
	}
}
