package launchcode.org.ExerciseTracker.models.service;

import launchcode.org.ExerciseTracker.dto.ExerciseDTO;
import launchcode.org.ExerciseTracker.dto.SetsDTO;
import launchcode.org.ExerciseTracker.models.Exercise;
import launchcode.org.ExerciseTracker.models.Sets;

import java.util.List;

public interface ExerciseService {

    //List<Exercise> findAll();
    List<Exercise> findByName(String name);
    //List<Exercise> findExerciseById(Long exerciseId);
    List<Sets> findSetsByExerciseId(Long exerciseId);
    Exercise add(ExerciseDTO added);

    Sets addSets(SetsDTO setsDTO);
    Sets findSetsById(Long setsId);
    Exercise findById(Long exId);

}
