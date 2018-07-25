package launchcode.org.ExerciseTracker.dto;

import launchcode.org.ExerciseTracker.models.Sets;

public class SetsDTO {
    private Long setsId;
    private int exerciseId;
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
    //other constructor? need to find out why we should have this
    public SetsDTO(Sets sets) {
        this.setsId = sets.getSetsId();
        this.exerciseId = sets.getExercise().getId();
    }


    //getters and setters
    public Long getSetsId() {
        return setsId;
    }

    public void setId(Long SetsId) {
        this.setsId = setsId;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
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
