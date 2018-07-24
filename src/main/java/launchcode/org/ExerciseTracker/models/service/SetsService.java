package launchcode.org.ExerciseTracker.models.service;

import launchcode.org.ExerciseTracker.dto.SetsDTO;
import launchcode.org.ExerciseTracker.models.Sets;

import java.util.List;


public interface SetsService {
    List<Sets> findSetsByExerciseId(int exerciseId);
    Sets addSets(SetsDTO setsDTO);
    Sets findSetsById(Integer id);
}
