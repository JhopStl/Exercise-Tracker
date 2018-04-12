package launchcode.org.ExerciseTracker.controllers;

import launchcode.org.ExerciseTracker.models.Exercise;
import launchcode.org.ExerciseTracker.models.data.ExerciseDao;
import launchcode.org.ExerciseTracker.models.data.wSessionDao;
import launchcode.org.ExerciseTracker.models.wSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "exercise")
public class ExerciseController {

    @Autowired
    private ExerciseDao exerciseDao;

    @Autowired
    private wSessionDao seshDao;

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
    //@RequestMapping(value = "add", method = RequestMethod.GET)

    @GetMapping("add")
    public String addExercise(Model model) {

        model.addAttribute("title", "Add Exercise");
        model.addAttribute(new Exercise());
        model.addAttribute("sessions", seshDao.findAllByOrderByIdDesc());
        return "exercise/add";
    }

    //process add Exercise form
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processExercise(@ModelAttribute Exercise newExercise, @RequestParam int seshId, Model model) {

        model.addAttribute("title", "Add Exercise");
        exerciseDao.save(newExercise);
       // return "redirect:/set/add";

        wSession sesh = seshDao.findOne(seshId);
        newExercise.setwSession(sesh);
        exerciseDao.save(newExercise);
        return "redirect:/set/add";
    }

    //views session page (when user clicks on session URL, they are directed to new page)
    //portal to view details about exercise
    @RequestMapping(value="view/{exId}", method = RequestMethod.GET)
    public String viewExercise(Model model, @PathVariable int exId) {

        // pull a session ID by making an instance of the exercise class and calling DAO
        Exercise exercise = exerciseDao.findOne(exId);
        model.addAttribute("title", exercise.getName());

        return "exercise/view";
    }



}
