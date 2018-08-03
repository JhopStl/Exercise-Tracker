package launchcode.org.ExerciseTracker.controllers;

import launchcode.org.ExerciseTracker.models.Exercise;
import launchcode.org.ExerciseTracker.models.Sets;
import launchcode.org.ExerciseTracker.models.data.ExerciseDao;
import launchcode.org.ExerciseTracker.models.data.SetDao;
import launchcode.org.ExerciseTracker.models.data.wSessionDao;
import launchcode.org.ExerciseTracker.models.wSession;
import launchcode.org.ExerciseTracker.utils.SetUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "exercise/")
public class ExerciseController {

    @Autowired
    private ExerciseDao exerciseDao;

    @Autowired
    private wSessionDao seshDao;

    @Autowired
    private SetDao setDao;

    //view Exercises...if this is needed/wanted
    @RequestMapping(value = "")
    public String exerciseIndex(Model model) {
        model.addAttribute("title", "Exercise");
        model.addAttribute("exercises", exerciseDao.findAll());
        return "exercise/index";
    }

    //handler to display add exercise form
    //use @PathVariable to pull in session ID from URL
    @GetMapping("add/{seshId}")
    public String addExercise(Model model, @PathVariable int seshId) {

        wSession wsessionId = seshDao.findOne(seshId);
        model.addAttribute("title", "Add Exercise");
        model.addAttribute(new Exercise());
        //no matter, what will pull a list of the most recently added session ID
        model.addAttribute("sessions", seshDao.findAllByOrderByIdDesc());
        //return exercise/add view
        return "exercise/exerciseForm";
    }

    //process add Exercise form
    @RequestMapping(value = "add/{seshId}", method = RequestMethod.POST)
    public String processExercise(@ModelAttribute Exercise newExercise, Model model, @PathVariable int seshId) {

        model.addAttribute("title", "Add Exercise");
        //exerciseDao.save(newExercise);

        wSession sesh = seshDao.findOne(seshId);
        newExercise.setwSession(sesh);
        exerciseDao.save(newExercise);

        //grab exercise Id and add to the redirect
        Long exId = newExercise.getExerciseId();
        return "redirect:/set/add/" + exId;
    }

    //views session page (when user clicks on session URL, they are directed to new page)
    //portal to view details about exercise
    @RequestMapping(value="view/{exId}", method = RequestMethod.GET)
    public String viewExercise(Model model, @PathVariable Long exId) {

        // pull a session ID by making an instance of the exercise class and calling DAO
        Exercise exercise = exerciseDao.findOne(exId);
        model.addAttribute("title", exercise.getName());

        return "exercise/view";
    }

    //Set handlers

    //list sets handler
    @RequestMapping(value="")
    public String setsIndex(Model model) {
        model.addAttribute("Sets", setDao.findAll());
        model.addAttribute("title", "Sets");
        return "set/index";
    }

    @GetMapping(value="add/{exId}")
    public String addSet(Model model, @PathVariable Long exId) {

        //Exercise exercise = exerciseDao.findOne(exId);
        model.addAttribute("title", "Add Set");
        model.addAttribute(new Sets());
        model.addAttribute("sets", exerciseDao.findOne(exId));
        return "set/add";

    }

    @RequestMapping(value="add/{exId}", params = {"addSets"}, method=RequestMethod.POST) //params specifies the method that spring will use
    public String addRow(final Exercise exercise) {
        Sets sets = new Sets ();
        //database sets ID? instead, create random negative ID
        sets.setSetsId(SetUtils.randomNegativeId());
        //adding new set added to the list
        exercise.getSetsList().add(sets);
        //setForm.getSetsList().add(sets);

        return "set/add";
    }



}
