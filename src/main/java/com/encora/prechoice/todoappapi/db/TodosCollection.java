package com.encora.prechoice.todoappapi.db;

import com.encora.prechoice.todoappapi.domain.Priority;
import com.encora.prechoice.todoappapi.domain.Todo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TodosCollection {
    private List<Todo> todos = new ArrayList<>();
    private int lastIndex = 0;

    public TodosCollection() {
        todos.add(new Todo(todos.size() + 1,
                "Finish react course",
                Priority.MEDIUM,
                LocalDateTime.now().minusDays(3).minusMinutes(20),
                null,
                LocalDateTime.now(),
                true
        ));

        todos.add(new Todo(todos.size() + 1,
                "Search for OS contributions",
                Priority.LOW,
                LocalDateTime.now().minusMinutes(20),
                LocalDate.of(2022, 10, 7),
                LocalDateTime.now(),
                true
        ));

        todos.add(new Todo(todos.size() + 1,
                "Write weekly essay",
                Priority.HIGH,
                LocalDateTime.now().minusHours(3),
                null,
                LocalDateTime.now(),
                true
        ));

        /*todos.add(new Todo(todos.size() + 1,
                "Mock interview",
                Priority.MEDIUM,
                LocalDateTime.now().minusMinutes(30)
        ));

        todos.add(new Todo(todos.size() + 1,
                "Finish task",
                Priority.HIGH,
                LocalDateTime.now().minusMinutes(10)
        ));

        todos.add(new Todo(todos.size() + 1,
                "Study for performance interview",
                Priority.LOW,
                LocalDateTime.now().minusMinutes(20),
                LocalDate.of(2022, 10, 7)
        ));*/

        lastIndex = todos.size();
    }

    @Override
    public String toString() {
        return "TodosCollection{" +
                "todos=" + todos +
                '}';
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public Todo addTodo(Todo todo) {
        todo.setId(++lastIndex);
        todos.add(todo);
        return todo;
    }

    public int getSize() {
        return todos.size();
    }

    public boolean deleteTodo(Todo todo) {
        return todos.remove(todo);
    }
}
