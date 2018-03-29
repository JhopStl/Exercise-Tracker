package launchcode.org.ExerciseTracker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Exercise {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @ManyToOne
    public wSession wSession;

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

    public launchcode.org.ExerciseTracker.models.wSession getwSession() {
        return wSession;
    }

    public void setwSession(launchcode.org.ExerciseTracker.models.wSession wSession) {
        this.wSession = wSession;
    }
}
