package launchcode.org.ExerciseTracker.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date; //use bootstrap date picker

@Entity
public class Workout {


    @Id //unique primary key column in DB
    @GeneratedValue //generates this value
    private int id;

    private String name;
    private java.util.Date Date;

    //constructor
    public Workout (String name, Date date) {
        this.name = name;
        this.Date = date;
    }

    //default constructor
    public Workout(){}

    //getters and setters


    public int getId() {
        return id;
    }
    //let DB set id

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
