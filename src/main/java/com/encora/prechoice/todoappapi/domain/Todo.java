package com.encora.prechoice.todoappapi.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Todo {
    private int id;
    private String name;
    private Priority priority;
    private Boolean done;
    private LocalDateTime creationDate;
    private LocalDate dueDate;
    private LocalDateTime completedDate;

    public Todo() {
        this.done = false;
        System.out.println("Default constructor");
    }

    public Todo(String name, Priority priority, LocalDateTime creationDate) {

        this();
        this.name = name;
        this.priority = priority;
        this.creationDate = creationDate;
        System.out.println("Segundo constructor. Name " + name);
    }

    public Todo(String name, Priority priority, LocalDateTime creationDate, LocalDate dueDate) {
        this(name, priority, creationDate);
        this.dueDate = dueDate;
        System.out.println("Tercer constructor. Name " + name);
    }

    public Todo(int id, String name, Priority priority, LocalDateTime creationDate) {
        this(name, priority, creationDate);
        this.id = id;
        System.out.println("Cuarto constructor. Name " + name);
    }

    public Todo(int id, String name, Priority priority, LocalDateTime creationDate, LocalDate dueDate) {
        this(name, priority, creationDate, dueDate);
        this.id = id;
        System.out.println("Quinto constructor. Name " + name);
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
