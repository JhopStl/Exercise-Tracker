package launchcode.org.ExerciseTracker.models.service;
import launchcode.org.ExerciseTracker.dto.SetsDTO;
import launchcode.org.ExerciseTracker.models.Exercise;
import launchcode.org.ExerciseTracker.models.Sets;
import launchcode.org.ExerciseTracker.models.data.ExerciseDao;
import launchcode.org.ExerciseTracker.models.data.SetDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;



@Service("setsService")
@Transactional
public class SetsServiceImpl implements SetsService {

    @Autowired
    private SetDao setDao;

    @Autowired
    private ExerciseDao exerciseDao;

    public List<Sets> findSetsByExerciseId(int exerciseId){
        return setDao.findByExercise_ExerciseId(exerciseId);
    }

    public Sets findSetsById(Long setsId) {
        return setDao.findBySetsId(setsId);
    }

    @Override
    @Transactional
    public Sets addSets(SetsDTO setsDTO) {
        Exercise exercise = exerciseDao.findOne(setsDTO.getExerciseId());
        Sets sets = new Sets(setsDTO.getRep(), setsDTO.getWeight());
        return setDao.save(sets);
    }

}
