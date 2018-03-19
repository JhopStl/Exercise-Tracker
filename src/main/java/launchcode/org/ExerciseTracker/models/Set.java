package launchcode.org.ExerciseTracker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Set {

    @Id
    @GeneratedValue
    private int id;
    private double weight;
    private int numRep;

    //constructor
    public Set (double weight, int numRep) {
        this.weight = weight;
        this.numRep = numRep;
    }

    //default constructor
    public Set (){}

    //getters and setters
    public int getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getNumRep() {
        return numRep;
    }

    public void setNumRep(int numRep) {
        this.numRep = numRep;
    }
}
