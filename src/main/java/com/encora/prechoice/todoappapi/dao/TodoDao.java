package com.encora.prechoice.todoappapi.dao;

import com.encora.prechoice.todoappapi.domain.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoDao {
    Todo save(Todo todo);
    Optional<Todo> findById(Integer id);
    List<Todo> findAll();
    long count();
    void delete(Todo todo);
    boolean existsById(Integer id);
}
