package com.encora.prechoice.todoappapi.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Todo {
    private int id;
    private String name;
    private Priority priority;
    private LocalDateTime creationDate;
    private LocalDate dueDate;
    private LocalDateTime completedDate;
    private Boolean done;

    public Todo() {}

    public Todo(String name, Priority priority, LocalDateTime creationDate, LocalDate dueDate) {
        this.name = name;
        this.priority = priority;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        this.done = false;
    }

    public Todo(int id, String name, Priority priority, LocalDateTime creationDate, LocalDate dueDate, LocalDateTime completedDate, Boolean done) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        this.completedDate = completedDate;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", priority=" + priority +
                ", done=" + done +
                ", creationDate=" + creationDate +
                ", dueDate=" + dueDate +
                ", completedDate=" + completedDate +
                '}';
    }
}
