package com.encora.prechoice.todoappapi.services;

import com.encora.prechoice.todoappapi.dao.TodoDAOCollectionImpl;
import com.encora.prechoice.todoappapi.domain.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoDAOCollectionImpl dao;

    public List<Todo> getTodos() {
        return dao.findAll();
    }

    public Todo createTodo(Todo todo) {
        return dao.save(todo);
    }

    public Optional<Todo> updateTodoStatus(int id, Boolean status) {
        return dao.updateStatus(id, status);
    }

}
