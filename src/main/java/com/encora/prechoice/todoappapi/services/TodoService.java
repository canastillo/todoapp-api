package com.encora.prechoice.todoappapi.services;

import com.encora.prechoice.todoappapi.dao.TodoDaoCollectionImpl;
import com.encora.prechoice.todoappapi.domain.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoDaoCollectionImpl dao;

    public List<Todo> getTodos() {
        return dao.findAll();
    }
}
