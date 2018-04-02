package launchcode.org.ExerciseTracker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Set {

    @Id
    @GeneratedValue
    private int id;
    private int rep;
    private double weight;

    //constructor
    public Set (int id, int rep, double weight) {
        this.id = id;
        this.rep = rep;
        this.weight = weight;
    }

    //default constructor
    public Set () {}
    
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
