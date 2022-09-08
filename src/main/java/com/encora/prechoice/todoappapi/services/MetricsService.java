package com.encora.prechoice.todoappapi.services;

import com.encora.prechoice.todoappapi.dao.TodoDAOCollectionImpl;
import com.encora.prechoice.todoappapi.domain.Priority;
import com.encora.prechoice.todoappapi.domain.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
public class MetricsService {
    @Autowired
    private TodoDAOCollectionImpl dao;

    public String getAvg() {
        List<Todo> doneTodos = dao.findByState(true);
        return calculateAvg(doneTodos);
    }

    public String getAvgByPriority(Priority priority) {
        List<Todo> todos = dao.findByPriority(priority);
        return calculateAvg(todos);
    }

    private String calculateAvg(List<Todo> todos) {
        long timeDifference = 0L;
        long avg = 0L;

        for(Todo todo: todos) {
            timeDifference += Duration.between(todo.getCreationDate(), todo.getCompletedDate()).toMillis();
        }

        if(todos.size() > 0) {
            avg = ((timeDifference / todos.size()) /1000) / 60;
        }

        return avg + " mins";
    }
}
