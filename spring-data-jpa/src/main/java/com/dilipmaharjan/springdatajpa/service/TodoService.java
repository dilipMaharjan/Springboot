package com.dilipmaharjan.springdatajpa.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
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
		Todo todoEntity = todoRepository.findById(todo.getId()).get();
		BeanUtils.copyProperties(todo, todoEntity);
		return todoRepository.save(todoEntity);
	}

	public Todo create(Todo todo) {
		todoRepository.save(todo);
		return todo;
	}

	public Todo findBy(String title) {

		return todoRepository.findByTitle(title);
	}

	public List<Todo> findBycreatedOnLessThanEqual(Date createdOn) {
		return todoRepository.findBycreatedOnLessThanEqual(createdOn);
	}
}
