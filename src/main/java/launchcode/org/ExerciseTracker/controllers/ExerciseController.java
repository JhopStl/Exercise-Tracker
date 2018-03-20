package launchcode.org.ExerciseTracker.controllers;

import launchcode.org.ExerciseTracker.models.Exercise;
import launchcode.org.ExerciseTracker.models.data.ExerciseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "exercise")
public class ExerciseController {

    @Autowired
    private ExerciseDao exerciseDao;


    //view Exercises...if this is needed/wanted
    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Exercise");
        model.addAttribute("exercises", exerciseDao.findAll());
        return "exercise/index";
    }

    //add new Exercise form
    //handler to display add Templates.exercise form
    //will need to add this form and tie it to the session id...one to many relationship
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addExercise(Model model) {

        model.addAttribute("title", "Add Exercise");
        model.addAttribute(new Exercise());
        return "exercise/add";
    }

    //process add Exercise form
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processExercise(@ModelAttribute Exercise newExercise, Model model) {

        model.addAttribute("title", "Add Exercise");
        exerciseDao.save(newExercise);
        return "redirect:";

    }

}
