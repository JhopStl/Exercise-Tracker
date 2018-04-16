package launchcode.org.ExerciseTracker.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Exercise {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    //for the wSession and Exercise relationship
    @ManyToOne //Many exercises to one session
    private wSession sesh;

    //for the Sets and Exercise relationship
    @OneToMany //One exercise to many sets
    @JoinColumn (name="ex_id")
    private List<Sets> sets = new ArrayList<>();


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

    public List<Sets> getSets() {
        return sets;
    }

    public void setSets(List<Sets> sets) {
        this.sets = sets;
    }
}
