package com.encora.prechoice.todoappapi.controllers;

import com.encora.prechoice.todoappapi.domain.Todo;
import com.encora.prechoice.todoappapi.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping()
    ResponseEntity<List<Todo>> getTodos() {
        List<Todo> response = todoService.getTodos();
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @PostMapping()
    ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        Todo newTodo = todoService.createTodo(todo);
        return new ResponseEntity<>(newTodo, HttpStatus.CREATED);
    }
}
