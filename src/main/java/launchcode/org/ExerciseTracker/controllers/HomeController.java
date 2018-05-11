package launchcode.org.ExerciseTracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "welcome")
public class HomeController {

    @RequestMapping(value="")
    public String index(Model model) {
        model.addAttribute("title", "GainzTracker");
        return "home/welcome";

    }
}
