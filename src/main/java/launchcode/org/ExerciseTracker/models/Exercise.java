package launchcode.org.ExerciseTracker.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Exercise {

    @Id
    @GeneratedValue
    private Long exerciseId;
    private String name;

    //for the wSession and Exercise relationship
    @ManyToOne //Many exercises to one session
    private wSession sesh;

    //for the Sets and Exercise relationship
    @OneToMany //One exercise to many sets
    @JoinColumn (name="exercise_id") //if it's different from the exercise instance declared in "sets" then it will create separate fields
    private List<Sets> sets = new ArrayList<>();


    //constructor
    public Exercise (String name) {
        this.name = name;
    }

    //default constructor
    public Exercise (){}


    //getters and setters

    public Long getId() {
        return exerciseId;
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
