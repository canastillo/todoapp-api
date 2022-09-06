package com.encora.prechoice.todoappapi.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Todo {
    private int id;
    private String task;
    private Priority priority;
    private Boolean done;
    private LocalDateTime creationDate;
    private LocalDate dueDate;
    private LocalDateTime completedDate;

    public Todo(int id, String task, Priority priority, LocalDateTime creationDate) {
        this.id = id;
        this.task = task;
        this.priority = priority;
        this.done = false;
        this.creationDate = creationDate;
    }

    public Todo(int id, String task, Priority priority, LocalDateTime creationDate, LocalDate dueDate) {
        this.id = id;
        this.task = task;
        this.priority = priority;
        this.done = false;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(LocalDateTime completedDate) {
        this.completedDate = completedDate;
    }
}
