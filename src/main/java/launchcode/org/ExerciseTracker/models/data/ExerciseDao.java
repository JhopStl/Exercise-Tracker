package launchcode.org.ExerciseTracker.models.data;

import launchcode.org.ExerciseTracker.models.Exercise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ExerciseDao extends CrudRepository<Exercise, Integer> {
}
