package launchcode.org.ExerciseTracker.Models;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date; //use bootstrap date picker

public class Workout {
    private String name;
    private java.util.Date Date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }
}
