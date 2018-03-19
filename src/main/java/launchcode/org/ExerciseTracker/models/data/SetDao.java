package launchcode.org.ExerciseTracker.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import launchcode.org.ExerciseTracker.models.Set;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface SetDao extends CrudRepository<Set,Integer> {
}
