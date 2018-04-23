package launchcode.org.ExerciseTracker.models;

import org.hibernate.validator.constraints.Email;
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
    @Transient
    private String password;
}
