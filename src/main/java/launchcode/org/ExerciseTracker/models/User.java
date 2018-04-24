package launchcode.org.ExerciseTracker.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @NotEmpty(message = "*Username is required")
    private String userName;

    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Email is required")
    private String email;

    @NotEmpty(message = "*Please provide a password")
    @Length(min=5, max=12, message = "*Your password must be between 5 and 12 characters")
    @Transient
    private String password;

    private int active;

    //constructor
    public User (String userName, String email, String password, int active){
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.active = active;
    }

    //default constructor
    public User () {}

    //getter and setters


    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
