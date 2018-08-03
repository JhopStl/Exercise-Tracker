package launchcode.org.ExerciseTracker.models.service;

import launchcode.org.ExerciseTracker.dto.SetsDTO;
import launchcode.org.ExerciseTracker.models.Exercise;
import launchcode.org.ExerciseTracker.models.Sets;

import java.util.List;

public interface ExerciseService {

    //List<Exercise> findAll();
    List<Exercise> findByName(String name);
    //List<Exercise> findExerciseById(Long exerciseId);

    List<Sets> findSetsByExerciseId(Long exerciseId);
    Sets addSets(SetsDTO setsDTO);
    Sets findSetsById(Long setsId);

}
