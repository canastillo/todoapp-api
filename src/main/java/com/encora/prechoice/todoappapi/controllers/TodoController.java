package com.encora.prechoice.todoappapi.controllers;

import com.encora.prechoice.todoappapi.domain.Todo;
import com.encora.prechoice.todoappapi.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping()
    List<Todo> getTodos() {
        return todoService.getTodos();
    }

}
