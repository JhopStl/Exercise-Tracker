package launchcode.org.ExerciseTracker.utils;

import java.util.Random;

public class SetUtils {

    //random negative ID
    public static int randomNegativeId()
    {
        Random rand = new Random();
        return -1 * ((int)rand.nextInt(1000));
    }
}
