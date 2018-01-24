package launchcode.org.ExerciseTracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "workout")
public class WorkoutController {


    //handler to list workout sessions (times went to the gym)
    @RequestMapping(value="")
    public String index(Model model) {

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
