package com.encora.prechoice.todoappapi.controllers;

import com.encora.prechoice.todoappapi.domain.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TodoControllerTest {

    @Autowired
    private RestTemplateBuilder templateBuilder;

    @Autowired
    private WebTestClient client;

   @Test
    void getAllTodos() {
       RestTemplate template = templateBuilder.build();
        //template.getForEntity("/todos", );
       // ResponseEntity<List<Todo>> response = template.getForEntity("/todos", List);
       ResponseEntity<List<Todo>> response =
               template.exchange(
                       "/todos",
                       HttpMethod.GET,
                       null,
                       new ParameterizedTypeReference<List<Todo>>() {}
               );

       //TodosCollection response = template.getForObject("/todos", TodosCollection.class);
       System.out.println(response.getBody());
       assertTrue(true);
       //assertTrue(response.getSize() > 0);
       assertEquals(HttpStatus.FOUND, response.getStatusCode());

    }

}
