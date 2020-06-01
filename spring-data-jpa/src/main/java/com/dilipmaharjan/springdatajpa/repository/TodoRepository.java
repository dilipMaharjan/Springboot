package com.dilipmaharjan.springdatajpa.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dilipmaharjan.springdatajpa.entity.Todo;

public interface TodoRepository extends CrudRepository<Todo, Integer> {
	List<Todo> findAll();

	Todo findByTitle(String title);

	List<Todo> findBycreatedOnLessThanEqual(Date createdOn);
}
