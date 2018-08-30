package launchcode.org.ExerciseTracker.models;

import launchcode.org.ExerciseTracker.dto.SetsDTO;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.core.style.ToStringCreator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Sets implements Serializable {

    @Id
    @GeneratedValue
    @Column(name ="sets_id", insertable = true, updatable = true) //defining the column name and details
    private Long setsId;

    @Basic
    @Column(name="rep", insertable = true, updatable = true)
    private Integer rep;

    @Basic
    @Column(name="weight", insertable = true, updatable = true)
    private Integer weight;

    private static final long serialVersionUID = 445689846;


    @ManyToOne //many sets to one exercise
    @JoinColumn(name = "exerciseId", referencedColumnName = "exerciseId", insertable = true, updatable = true)
    private Exercise exercise;


    //default constructor
    public Sets () {}

    //constructor
    public Sets (SetsDTO setsDTO) {
        this.rep = setsDTO.getRep();
        this.weight = setsDTO.getWeight();
    }

    public Sets (Integer rep, Integer weight) {
        this.rep = rep;
        this.weight = weight;
    }

    //method to check if Sets is new (checks if ID value is null)
    @Transient
    public boolean isNew() {return (this.setsId == null);}

    //getters and setters

    public Long getSetsId() { return setsId; }

    public void setSetsId(Long setsId) { this.setsId = setsId; }


    public Integer getRep() {
        return rep;
    }

    public void setRep(Integer rep) {
        this.rep = rep;
    }


    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }


    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    //change objects to Strings to better handle different types, null values etc.
    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("setsId", this.getSetsId())
                .append("new", this.isNew())
                .append("exercise", this.getExercise().getExerciseId())
                .append("rep", this.getRep())
                .append("weight", this.getWeight())
                .toString();
    }

    //pull in exercise
    public static Builder getBuilder(Exercise exercise, Integer rep, Integer weight) {
        return new Builder(exercise, rep, weight);
    }

    public static class Builder {
        private Sets built;

        public Builder(Exercise exercise, Integer rep, Integer weight) {
            built = new Sets();
            built.exercise = exercise;
            built.rep = rep;
            built.weight = weight;
        }

        public Sets build() {return built;}
    }
}
