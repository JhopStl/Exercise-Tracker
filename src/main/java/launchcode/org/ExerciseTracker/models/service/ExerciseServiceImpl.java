package launchcode.org.ExerciseTracker.models.service;


import launchcode.org.ExerciseTracker.dto.SetsDTO;
import launchcode.org.ExerciseTracker.models.Exercise;
import launchcode.org.ExerciseTracker.models.Sets;
import launchcode.org.ExerciseTracker.models.data.ExerciseDao;
import launchcode.org.ExerciseTracker.models.data.SetDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.expression.Lists;

import javax.transaction.Transactional;
import java.util.List;

@Service("exerciseService")
@Transactional
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    private ExerciseDao exerciseDao;

    @Autowired
    private SetDao setDao;

    //@Transactional
    //public List<Exercise> findAll() {
        //return Lists.newArrayList(exerciseDao.findAll());
    //}

    @Transactional
    public List<Exercise> findByName(String name) {
        return exerciseDao.findByName(name);
    }

    @Transactional
    public List<Exercise> findExerciseById(Long exerciseId) {
        return exerciseDao.findExerciseById(exerciseId);
    }

    @Transactional
    public List<Sets> findSetsByExerciseId(Long exerciseId) {
        return setDao.findByExercise_ExerciseId(exerciseId);
    }

    @Transactional
    public Sets addSets(SetsDTO setsDTO) {
        Exercise exercise = exerciseDao.findOne(setsDTO.getExerciseId());
        Sets sets = new Sets (setsDTO.getRep(), setsDTO.getWeight());

        return setDao.save(sets);
    }

    @Transactional
    public Sets findSetsById (Long setsId) {
        return setDao.findBySetsId(setsId);
    }

}
