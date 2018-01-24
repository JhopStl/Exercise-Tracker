package launchcode.org.ExerciseTracker.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import java.util.Date; //use bootstrap date picker

@Entity
public class Workout {
    private String name;
    private java.util.Date Date;
    private int id;

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
