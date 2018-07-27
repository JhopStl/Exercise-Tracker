package launchcode.org.ExerciseTracker.dto;

import launchcode.org.ExerciseTracker.models.Sets;

public class SetsDTO {
    private Long setsId;
    private Long exerciseId;
    private int rep;
    private double weight;


    //empty constructor
    public SetsDTO(){}

    //constructor
    public SetsDTO(int rep, double weight) {
        this.rep = rep;
        this.weight = weight;
    }

    //overloading method
    //ties SetsDTO to the Sets model class
    public SetsDTO(Sets sets) {
        this.setsId = sets.getSetsId();
        this.exerciseId = sets.getExercise().getExerciseId();
        this.rep = sets.getRep();
        this.weight = sets.getWeight();
    }


    //getters and setters
    public Long getSetsId() {
        return setsId;
    }

    public void setSetsId(Long setsId) {
        this.setsId = setsId;
    }

    public Long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
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
