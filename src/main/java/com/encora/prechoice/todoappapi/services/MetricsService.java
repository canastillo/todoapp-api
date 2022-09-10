package com.encora.prechoice.todoappapi.services;

import com.encora.prechoice.todoappapi.dao.TodoDAOCollectionImpl;
import com.encora.prechoice.todoappapi.domain.Priority;
import com.encora.prechoice.todoappapi.domain.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class MetricsService {
    @Autowired
    private TodoDAOCollectionImpl dao;

    public String getAvg() {
        List<Todo> doneTodos = dao.findByState(true);

        if (doneTodos.size() > 0)
            return calculateAvg(doneTodos);

        return "-";
    }

    public String getAvgByPriority(Priority priority) {
        List<Todo> todos = dao.findDoneByPriority(priority);

        if (todos.size() > 0)
            return calculateAvg(todos);

        return "-";
    }

    private String calculateAvg(List<Todo> todos) {
        long avgMilliseconds;
        String unit = "";
        StringBuilder strBldr = new StringBuilder();
        boolean[] showUnits = {false, false, false, false};                 // These represent if days/hours/minutes/seconds should be shown
        long[] unitsAmount = {0L, 0L, 0L, 0L};                                    // These are the amount of days/hours/minutes/seconds

        avgMilliseconds = getAvgInMillis(todos);
        unit = getUnit(avgMilliseconds);

        switch (unit) {
            case "days":
                showUnits[0] = true;
                break;
            case "hours":
                showUnits[1] = true;
                break;
            case "minutes":
                showUnits[2] = true;
                break;
            case "seconds":
                showUnits[3] = true;
                break;
        }

        unitsAmount[0] = TimeUnit.MILLISECONDS.toDays(avgMilliseconds);
        if (unitsAmount[0] > 0) {
            avgMilliseconds = getRemainingTime(TimeUnit.DAYS.toMillis(unitsAmount[0]), avgMilliseconds);
            showUnits[0] = true;
        }

        unitsAmount[1] = TimeUnit.MILLISECONDS.toHours(avgMilliseconds);
        if (unitsAmount[1] > 0) {
            avgMilliseconds = getRemainingTime(TimeUnit.HOURS.toMillis(unitsAmount[1]), avgMilliseconds);
            showUnits[1] = true;
        }

        unitsAmount[2] = TimeUnit.MILLISECONDS.toMinutes(avgMilliseconds);
        if (unitsAmount[2] > 0) {
            avgMilliseconds = getRemainingTime(TimeUnit.MINUTES.toMillis(unitsAmount[2]), avgMilliseconds);

            showUnits[2] = true;
            if (showUnits[0]) showUnits[1] = true;
        }

        unitsAmount[3] = TimeUnit.MILLISECONDS.toSeconds(avgMilliseconds);
        if (unitsAmount[3] > 0) {
            avgMilliseconds = getRemainingTime(TimeUnit.SECONDS.toMillis(unitsAmount[3]), avgMilliseconds);
            showUnits[3] = true;
            if (showUnits[1]) showUnits[2] = true;
        }

        buildAverageString(showUnits, unitsAmount, unit, strBldr);

        return strBldr.toString();
    }

    private long getAvgInMillis(List<Todo> todos) {
        long timeDifference = 0L;

        for(Todo todo: todos) {
            timeDifference += Duration.between(todo.getCreationDate(),
                    todo.getCompletedDate()).toMillis();
        }

        return timeDifference / todos.size();
    }

    private String getUnit(long avgMilliseconds) {
        return avgMilliseconds > TimeUnit.DAYS.toMillis(1) - 1 ? "days" :
                avgMilliseconds > TimeUnit.HOURS.toMillis(1) - 1 ? "hours" :
                        avgMilliseconds > TimeUnit.SECONDS.toMillis(1) - 1 ? "minutes" : "seconds";
    }

    private long getRemainingTime(long timeInMillis, long remainingTime) {
        remainingTime -= timeInMillis;
        return  remainingTime;
    }

    private void buildAverageString(boolean[] showUnits, long[] unitsAmount, String unit, StringBuilder strBldr) {

        for (int i = 0; i <= 3; i++) {
            if (showUnits[i]) {
                if (strBldr.length() > 0) strBldr.append(":");
                strBldr.append(String.format("%02d", unitsAmount[i]));
            }
        }

        strBldr.append(" " + unit);
    }
}
