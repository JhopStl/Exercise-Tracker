package launchcode.org.ExerciseTracker.dto;

import launchcode.org.ExerciseTracker.models.Exercise;
import launchcode.org.ExerciseTracker.models.wSession;

import java.util.List;

public class ExerciseDTO {
    private Long exerciseID;
    private String name;
    private List<SetsDTO> setsList;
    private wSession sesh;

    //Empty constructor
    public ExerciseDTO() {}

    //Constructor
    //public ExerciseDTO(String name) {
        //this.name = name;
   // }

    //Constructor
    //Ties ExerciseDTO to the Exercise model class
    public ExerciseDTO (Exercise exercise) {
        this.exerciseID = exercise.getExerciseId();
        this.name = exercise.getName();
        this.sesh = exercise.getwSession();
    }

    public Long getExerciseID() {
        return exerciseID;
    }

    public void setExerciseID(Long exerciseID) {
        this.exerciseID = exerciseID;
    }

    public List<SetsDTO> getSetsList() {
        return setsList;
    }

    public void setSetsList(List<SetsDTO> sets) {
        this.setsList = sets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public wSession getSesh() {
        return sesh;
    }

    public void setSesh(wSession sesh) {
        this.sesh = sesh;
    }
}
