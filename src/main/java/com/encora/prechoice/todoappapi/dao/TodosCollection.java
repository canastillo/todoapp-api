package com.encora.prechoice.todoappapi.dao;

import com.encora.prechoice.todoappapi.domain.Priority;
import com.encora.prechoice.todoappapi.domain.Todo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TodosCollection {
    private List<Todo> todos = new ArrayList<>();

    public TodosCollection() {
        todos.add(new Todo(1, "Finish react course", Priority.MEDIUM, LocalDateTime.now()));
        todos.add(new Todo(2, "Search for OS contributions", Priority.LOW, LocalDateTime.now(), LocalDate.of(2022, 10, 7)));
        todos.add(new Todo(3, "Write weekly essay", Priority.HIGH, LocalDateTime.now()));
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void addTodo(Todo todo) {
        todos.add(todo);
    }
}
