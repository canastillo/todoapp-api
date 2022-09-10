package com.encora.prechoice.todoappapi.controllers;

import com.encora.prechoice.todoappapi.domain.Priority;
import com.encora.prechoice.todoappapi.domain.Todo;
import com.encora.prechoice.todoappapi.services.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/metrics")
@CrossOrigin(origins = "http://localhost:8080")
public class MetricsController {

    @Autowired
    private MetricsService metricsService;

    @GetMapping()
    public ResponseEntity<Map<String, String>> getMetrics() {
        Map<String, String> metrics = new HashMap<>();

        metrics.put("overall", metricsService.getAvg());
        metrics.put("high", metricsService.getAvgByPriority(Priority.HIGH));
        metrics.put("medium", metricsService.getAvgByPriority(Priority.MEDIUM));
        metrics.put("low", metricsService.getAvgByPriority(Priority.LOW));

        return new ResponseEntity<>(metrics, HttpStatus.OK);
    }

    @GetMapping("/overall")
    public ResponseEntity<String> getOverallAvg() {
        return new ResponseEntity<>(metricsService.getAvg(), HttpStatus.OK);
    }

    @GetMapping("/{priority}")
    public ResponseEntity<String> getAvgByPriority(@PathVariable String priority) {
        String avg = metricsService.getAvgByPriority(Priority.valueOf(priority.toUpperCase()));
        return new ResponseEntity<>(avg, HttpStatus.OK);
    }

}
