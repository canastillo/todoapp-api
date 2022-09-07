package com.encora.prechoice.todoappapi.dao;

import com.encora.prechoice.todoappapi.db.TodosCollection;
import com.encora.prechoice.todoappapi.domain.Todo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TodoDAOCollectionImpl implements TodoDAO {

    private TodosCollection todosCollection = new TodosCollection();

    @Override
    public Todo save(Todo todo) {
        System.out.println("El DAO recibio " + todo);
        Todo updatedTodo = todosCollection.addTodo(todo);
        return updatedTodo;
    }

    @Override
    public Optional<Todo> findById(Integer id) {
        return Optional.empty();
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
    public void delete(Todo todo) {

    }

    @Override
    public boolean existsById(Integer id) {
        return false;
    }
}
