package launchcode.org.ExerciseTracker.models.service;

import launchcode.org.ExerciseTracker.models.Role;
import launchcode.org.ExerciseTracker.models.User;
import launchcode.org.ExerciseTracker.models.data.RoleDao;
import launchcode.org.ExerciseTracker.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public User findUserById(int id) { return userDao.findById(id);}

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleDao.findByRole("USER");
        //assigns a user to a role (in this case, it should always be "user")
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userDao.save(user);
    }
}
