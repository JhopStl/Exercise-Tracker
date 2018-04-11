package launchcode.org.ExerciseTracker.models;

import javax.persistence.*;

@Entity
public class Exercise {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @ManyToOne //Many exercises to one session
    private wSession sesh;

    //constructor
    public Exercise (String name) {
        this.name = name;
    }

    //default constructor
    public Exercise (){}


    //getters and setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public wSession getwSession() {
        return sesh;
    }

    public void setwSession(wSession sesh) {
            this.sesh = sesh;
    }
}
