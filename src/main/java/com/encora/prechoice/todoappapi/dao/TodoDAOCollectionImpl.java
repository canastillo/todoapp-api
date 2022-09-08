package com.encora.prechoice.todoappapi.dao;

import com.encora.prechoice.todoappapi.db.TodosCollection;
import com.encora.prechoice.todoappapi.domain.Priority;
import com.encora.prechoice.todoappapi.domain.Todo;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class TodoDAOCollectionImpl implements TodoDAO {

    private TodosCollection todosCollection = new TodosCollection();

    @Override
    public Todo save(Todo todo) {
        Todo updatedTodo = todosCollection.addTodo(todo);
        return updatedTodo;
    }

    @Override
    public List<Todo> findAll() {
        return todosCollection.getTodos();
    }

    @Override
    public Optional<Todo> findById(Integer id) {
        Optional<Todo> foundTodo = todosCollection.getTodos().stream()
                .filter(td -> td.getId() == id).findFirst();

        return foundTodo;
    }

    @Override
    public List<Todo> findByPriority(Priority priority) {
        List<Todo> todosByPriority = todosCollection.getTodos().stream()
                .filter(todo -> todo.getPriority().equals(priority)).collect(Collectors.toList());
        return todosByPriority;
    }

    @Override
    public List<Todo> findByState(boolean state) {
        List<Todo> todosByState = todosCollection.getTodos().stream()
                .filter(todo -> todo.getDone() == state).collect(Collectors.toList());
        return todosByState;
    }


    @Override
    public int count() {
        return todosCollection.getSize();
    }

    @Override
    public boolean delete(Todo todo) {
        return todosCollection.deleteTodo(todo);
    }

    @Override
    public boolean existsById(Integer id) {
        Optional<Todo> foundTodo = todosCollection.getTodos().stream()
                .filter(td -> td.getId() == id).findFirst();

        return foundTodo.isPresent();
    }

    @Override
    public Optional<Todo> updateStatus(int id, Boolean status) {
        Optional<Todo> todo = findById(id);

        if (todo.isPresent()) {
            todo.get().setDone(status);

            if (status) todo.get().setCompletedDate(LocalDateTime.now());
            else        todo.get().setCompletedDate(null);
        }
        
        return todo;
    }
}
