package com.encora.prechoice.todoappapi.dao;

import com.encora.prechoice.todoappapi.domain.Todo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TodoDAOCollectionImpl implements TodoDAO {

    TodosCollection todosCollection = new TodosCollection();

    @Override
    public Todo save(Todo todo) {
        return null;
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
    public long count() {
        return 0;
    }

    @Override
    public void delete(Todo todo) {

    }

    @Override
    public boolean existsById(Integer id) {
        return false;
    }
}
