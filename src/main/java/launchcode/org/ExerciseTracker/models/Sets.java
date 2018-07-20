package launchcode.org.ExerciseTracker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Sets {

    @Id
    @GeneratedValue
    private int id;

    private int rep;
    private double weight;

    @ManyToOne //many sets to one exercise
    private Exercise exercise;

    //constructor
    public Sets (int rep, double weight) {
        this.rep = rep;
        this.weight = weight;
    }

    //default constructor
    public Sets () {}

    //getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Exercise getExercise() {
        return exercise;
    }

    //test

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}
