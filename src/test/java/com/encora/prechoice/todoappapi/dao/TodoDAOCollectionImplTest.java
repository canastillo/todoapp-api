package com.encora.prechoice.todoappapi.dao;

import com.encora.prechoice.todoappapi.domain.Priority;
import com.encora.prechoice.todoappapi.domain.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TodoDAOCollectionImplTest {

    @Autowired
    TodoDAOCollectionImpl dao;

    @Test
    public void getAllTodos() {
        List<String> tasks = dao.findAll().stream().map(Todo::getName).collect(Collectors.toList());
        assertThat(tasks, containsInAnyOrder("Finish react course", "Search for OS contributions", "Write weekly essay"));
    }

    @Test
    public void addNewTodoWithDueDate() {
        Todo todo = new Todo("Test DAO layer", Priority.HIGH, LocalDateTime.now(), LocalDate.of(2022, 10, 18));
        int prevSize = dao.count();

        Todo updatedTodo = dao.save(todo);

        assertEquals(prevSize + 1, dao.count());
        assertFalse(updatedTodo.getDone());
        assertNotNull(updatedTodo.getDueDate());
        assertNotEquals(0, updatedTodo.getId());
    }

    @Test
    public void addNewTodoWithNoDueDate() {
        Todo todo = new Todo("Studying for exam", Priority.MEDIUM, LocalDateTime.now(), null);
        int prevSize = dao.count();

        Todo updatedTodo = dao.save(todo);

        assertEquals(prevSize + 1, dao.count());
        assertFalse(updatedTodo.getDone());
        assertNotEquals(0, updatedTodo.getId());

    }

}
