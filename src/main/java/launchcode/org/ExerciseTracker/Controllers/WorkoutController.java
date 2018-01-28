package launchcode.org.ExerciseTracker.controllers;

import launchcode.org.ExerciseTracker.models.data.WorkoutDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "workout")
public class WorkoutController {

   //add new Workout Data Object
    @Autowired
    private WorkoutDao workoutDao;

    //handler to list workout sessions (times went to the gym)
    @RequestMapping(value="")
    public String index(Model model) {
        model.addAttribute("workouts", workoutDao.findAll());
      model.addAttribute("title", "Workout Session");
      return "workout/index";

    }

    //handler to display add workout form
    @RequestMapping(value="add")
    public String addWorkout(Model model) {

        model.addAttribute("title", "Add Workout");
        return "workout/add";
    }
}
