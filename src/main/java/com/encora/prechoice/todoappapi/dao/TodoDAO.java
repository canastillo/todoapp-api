package com.encora.prechoice.todoappapi.dao;

import com.encora.prechoice.todoappapi.domain.Priority;
import com.encora.prechoice.todoappapi.domain.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoDAO {
    Todo save(Todo todo);
    List<Todo> findAll();
    Optional<Todo> findById(Integer id);
    List<Todo> findByState(boolean state);
    List<Todo> findByPriority(Priority priority);
    List<Todo> findDoneByPriority(Priority priority);
    int count();
    boolean delete(Todo todo);
    boolean existsById(Integer id);
    Optional<Todo> updateStatus(int id, Boolean status);
}
