package launchcode.org.ExerciseTracker.models.data;

import launchcode.org.ExerciseTracker.ExerciseTrackerApplication;
import launchcode.org.ExerciseTracker.dto.ExerciseDTO;
import launchcode.org.ExerciseTracker.models.Exercise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ExerciseDao extends CrudRepository<Exercise, Long> {
    List<Exercise> findByName (String name);
    //Exercise findById (Long exID);
    //List<Exercise> findExerciseById (Long exerciseID);

}
