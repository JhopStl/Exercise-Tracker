package launchcode.org.ExerciseTracker.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty(message = "*Username is required")
    private String userName;

    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Email is required")
    private String email;

    @NotEmpty(message = "*Please provide a password")
    @Column(name="password")
    //@Length(min=5, max=12, message = "*Your password must be between 5 and 12 characters")
    //@Transient
    private String password;

    private int active;

    //handles the many to many join between user and role
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="user_role", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name="role_id"))
    //stores the roles that have been joined
    private Set<Role> roles;

    //for the wSession and user relationship
    @OneToMany
    @JoinTable(name = "user_id")
    private List<wSession> wSessions = new ArrayList<>();

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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<wSession> getwSessions() {
        return wSessions;
    }

    public void setwSessions(List<wSession> wSessions) {
        this.wSessions = wSessions;
    }
}
