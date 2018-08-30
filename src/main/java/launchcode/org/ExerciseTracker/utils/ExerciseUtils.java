package launchcode.org.ExerciseTracker.utils;

import launchcode.org.ExerciseTracker.dto.ExerciseDTO;
import launchcode.org.ExerciseTracker.dto.SetsDTO;
import launchcode.org.ExerciseTracker.models.Exercise;

import java.util.Random;
import java.util.stream.Collectors;

public class ExerciseUtils {

    //random negative id
    public static Long randomNegativeId() {
        Random rand = new Random();
        return -1 * ((long)rand.nextInt(1000));
    }

    public static ExerciseDTO exerciseToExerciseDTO(Exercise exercise){
        ExerciseDTO dto = new ExerciseDTO();

        dto.setExerciseID(exercise.getExerciseId());
        dto.setName(exercise.getName());
        if (exercise.getSetsList() != null) {
            dto.setSetsList(exercise.getSetsList()
            .stream()
            .map(SetsDTO::new)
                            .collect(Collectors.toList()));
        }
        return dto;
    }
}
