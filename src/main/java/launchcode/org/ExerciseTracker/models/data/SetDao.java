package launchcode.org.ExerciseTracker.models.data;

import launchcode.org.ExerciseTracker.models.Sets;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface SetDao extends CrudRepository <Sets, Integer> {
    Sets findById(int id);
    List<Sets> findAllById(int exercise_id);
}
