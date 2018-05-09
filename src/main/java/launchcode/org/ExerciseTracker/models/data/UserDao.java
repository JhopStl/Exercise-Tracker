package launchcode.org.ExerciseTracker.models.data;

import launchcode.org.ExerciseTracker.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public interface UserDao extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findById(int id);
}
