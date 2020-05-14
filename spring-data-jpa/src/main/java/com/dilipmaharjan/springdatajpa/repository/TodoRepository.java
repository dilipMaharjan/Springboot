package com.dilipmaharjan.springdatajpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dilipmaharjan.springdatajpa.entity.Todo;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Integer> {
	List<Todo> findAll();
}
