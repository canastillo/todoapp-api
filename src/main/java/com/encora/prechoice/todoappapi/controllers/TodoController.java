package com.encora.prechoice.todoappapi.controllers;

import com.encora.prechoice.todoappapi.domain.Todo;
import com.encora.prechoice.todoappapi.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping()
    public ResponseEntity<List<Todo>> getTodos() {
        List<Todo> response = todoService.getTodos();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        Todo newTodo = todoService.createTodo(todo);
        return new ResponseEntity<>(newTodo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/done")
    public ResponseEntity<Optional<Todo>> updateDone(@PathVariable(value = "id") Integer id) {
        Optional<Todo> updatedTodo = todoService.updateTodoStatus(id, true);

        if (updatedTodo.isPresent())
            return new ResponseEntity<>(updatedTodo, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}/undone")
    public ResponseEntity<Optional<Todo>> updateUndone(@PathVariable(value = "id") Integer id) {
        Optional<Todo> updatedTodo = todoService.updateTodoStatus(id, false);

        if (updatedTodo.isPresent())
            return new ResponseEntity<>(updatedTodo, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
