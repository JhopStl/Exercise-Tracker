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

    @OneToMany //for everyone session, there are many exercises
    @JoinColumn
    private List<wSession> sessions = new ArrayList<>();

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

    public List<wSession> getSessions() {
        return sessions;
    }

    public void setSessions(List<wSession> sessions) {
        this.sessions = sessions;
    }
}
