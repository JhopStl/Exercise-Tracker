package launchcode.org.ExerciseTracker.controllers;


import launchcode.org.ExerciseTracker.models.User;
import launchcode.org.ExerciseTracker.models.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @Autowired
    public UserService userService;

    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String login (Model model) {
        model.addAttribute("title", "Login");
        //User user = new User();
        //model.addAttribute("user", user);
        return "login/login";
    }

    //display registration form
    @RequestMapping(value="/registration", method=RequestMethod.GET)
    public String registration (Model model) {
        User user = new User();
        model.addAttribute("title", "Sign Up");
        model.addAttribute("user", user);
        return "login/registration";
    }
}
