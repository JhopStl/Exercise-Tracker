package launchcode.org.ExerciseTracker.models;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date; //use bootstrap date picker
import java.util.List;

//@Entity tells Spring boot that this class is stored in a relational database
//Every field in class is stored in a DB unless you tell it not to be
@Entity
public class wSession {


    @Id //unique primary key column in DB
    @GeneratedValue //the data layer should generate this value for us
    private int id;

    private String name;

    //private java.util.Date Date;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date Date;

    //for the wSession and exercise relationship
    @OneToMany//one wSession for many exercises
    @JoinColumn(name="sesh_id")
    private List<Exercise> exercises = new ArrayList<>();

    //for the wSession and user relationship
    @ManyToOne//many wSession to one User
    private User user;

    //constructor
    //these fields need to match those in the view (form fields, etc.)
    public wSession (String name, Date date) {
        this.name = name;
        this.Date = date;
    }

    //default constructor - each persistent class needs one
    public wSession(){}

    //getters and setters


    public int getId() {
        return id;
    }
    //no setter because it should not be changed outside of this class

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public List<Exercise> getExercises() { return exercises; }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}