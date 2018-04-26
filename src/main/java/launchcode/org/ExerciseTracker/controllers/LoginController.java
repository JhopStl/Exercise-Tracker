package launchcode.org.ExerciseTracker.controllers;


import launchcode.org.ExerciseTracker.models.User;
import launchcode.org.ExerciseTracker.models.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    public UserService userService;

    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String login (Model model) {
        model.addAttribute("title", "Login");
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

    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String createUser(@Valid User user, BindingResult bindingResult, Model model) {
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult.rejectValue("email", "error.user", "User already registered with this email");
        }
        if (bindingResult.hasErrors()) {
            return "login/registration";
        } else {
            userService.saveUser(user);
            model.addAttribute("successMessage", "User has been registered successfully");
            model.addAttribute("user", new User());
            return "login/registration";
        }
    }

    @RequestMapping(value="home", method=RequestMethod.GET)
    public String authUser(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        model.addAttribute("userName", "Welcome " + user.getUserName());
        return "home/home";
    }
}
