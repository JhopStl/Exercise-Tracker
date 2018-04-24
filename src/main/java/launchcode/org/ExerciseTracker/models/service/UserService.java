package launchcode.org.ExerciseTracker.models.service;

import launchcode.org.ExerciseTracker.models.User;

//service layer provides logic to operate on data sent to and from the DAO and the client. Provides extra layer of security
public interface UserService {
    User findUserByEmail(String email);
    void saveUser(User user);
}

