package launchcode.org.ExerciseTracker.models;

import launchcode.org.ExerciseTracker.dto.SetsDTO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Sets implements Serializable {

    @Id
    @GeneratedValue
    private Long setsId;
    private int rep;
    private double weight;

    private static final long serialVersionUID = 445689846;


    @ManyToOne //many sets to one exercise
    private Exercise exercise;

    //constructor
    public Sets (SetsDTO setsDTO) {
        this.rep = setsDTO.getRep();
        this.weight = setsDTO.getWeight();
    }

    //default constructor
    public Sets () {}

    //method to check if Sets is new (checks if ID value is null)
    @Transient
    public boolean isNew() {return (this.setsId == null);}

    //getters and setters

    public Long getSetsId() { return setsId; }

    public void setSetsId(Long setsId) { this.setsId = setsId; }


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
    
    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}
