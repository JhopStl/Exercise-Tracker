package launchcode.org.ExerciseTracker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sets {

    @Id
    @GeneratedValue
    private int id;


    private int rep;
    private double weight;

    //constructor
    public Sets (int id, int rep, double weight) {
        this.id = id;
        this.rep = rep;
        this.weight = weight;
    }

    //default constructor
    public Sets () {}

    //getters and setters

    public int getId() {
        return id;
    }


    public int getRep() {
        return rep;
    }

    public void setRep(int rep) {
        this.rep = rep;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
