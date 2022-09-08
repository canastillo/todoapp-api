package com.encora.prechoice.todoappapi.controllers;

import com.encora.prechoice.todoappapi.domain.Priority;
import com.encora.prechoice.todoappapi.domain.Todo;
import com.encora.prechoice.todoappapi.services.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/metrics")
public class MetricsController {

    @Autowired
    private MetricsService metricsService;

    @GetMapping()
    public ResponseEntity<String> getAvgByPriority(@RequestParam(required = false) String priority) {
        if(priority != null) {
            String avg = metricsService.getAvgByPriority(Priority.valueOf(priority.toUpperCase()));
            return new ResponseEntity<>(avg, HttpStatus.OK);

        }

        return new ResponseEntity<>(metricsService.getAvg(), HttpStatus.OK);
    }
}
