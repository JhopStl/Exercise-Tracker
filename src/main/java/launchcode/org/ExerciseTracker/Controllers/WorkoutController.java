package launchcode.org.ExerciseTracker.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "workout")
public class WorkoutController {

    @RequestMapping(value="")
    public String index(Model model) {

      model.addAttribute("title", "Workout Session");
      return "workout/index";
    }
}
