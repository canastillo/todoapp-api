package com.encora.prechoice.todoappapi.dao;

import com.encora.prechoice.todoappapi.db.TodosCollection;
import com.encora.prechoice.todoappapi.domain.Todo;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class TodoDAOCollectionImpl implements TodoDAO {

    private TodosCollection todosCollection = new TodosCollection();

    @Override
    public Todo save(Todo todo) {
        Todo updatedTodo = todosCollection.addTodo(todo);
        return updatedTodo;
    }

    @Override
    public Optional<Todo> findById(Integer id) {
        Optional<Todo> foundTodo = todosCollection.getTodos().stream()
                .filter(td -> td.getId() == id).findFirst();

        return foundTodo;
    }

    @Override
    public List<Todo> findAll() {
        return todosCollection.getTodos();
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
