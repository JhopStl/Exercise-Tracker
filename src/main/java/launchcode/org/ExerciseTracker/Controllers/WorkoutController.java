package launchcode.org.ExerciseTracker.controllers;

import launchcode.org.ExerciseTracker.models.Workout;
import launchcode.org.ExerciseTracker.models.data.WorkoutDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "session")
public class WorkoutController {


    //@Autowired gives an instance of the WorkoutDao class by the framework
    @Autowired
    private WorkoutDao workoutDao;

    //handler to list workout sessions (times went to the gym)
    //Will return all the Workouts in the database
    //links view to Workoutdao
    @RequestMapping(value="")
    public String index(Model model) {
        model.addAttribute("workouts", workoutDao.findAll());
      model.addAttribute("title", "Session");
      return "workout/index";

    }

    //handler to display add workout form
    //get request
    @RequestMapping(value="add", method = RequestMethod.GET)
    public String addWorkout(Model model) {

        model.addAttribute("title", "Add Session");
        model.addAttribute(new Workout());
        return "workout/add";
    }
    //creates a new Workout object and saves it to DB
    @RequestMapping(value="add", method = RequestMethod.POST)
    public String processWorkout(@ModelAttribute Workout newWorkout, Model model) {

        model.addAttribute("title", "Add Session");

        //save workout to DB
        workoutDao.save(newWorkout);
        return "redirect:";
    }
}
