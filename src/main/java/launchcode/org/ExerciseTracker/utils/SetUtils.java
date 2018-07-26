package launchcode.org.ExerciseTracker.utils;

import java.util.Random;

public class SetUtils {

    //random negative ID
    public static Long randomNegativeId()
    {
        Random rand = new Random();
        return -1 * ((long)rand.nextInt(1000));
    }
}
