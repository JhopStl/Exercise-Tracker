package launchcode.org.ExerciseTracker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Set {

    @Id
    @GeneratedValue
    private int Id;
    private double Weight;
    private int Rep;

}
