package launchcode.org.ExerciseTracker.controllers;

import launchcode.org.ExerciseTracker.models.Exercise;
import launchcode.org.ExerciseTracker.models.SetList;
import launchcode.org.ExerciseTracker.models.Sets;
import launchcode.org.ExerciseTracker.models.data.ExerciseDao;
import launchcode.org.ExerciseTracker.models.data.SetDao;
import launchcode.org.ExerciseTracker.models.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping (value = "set")
public class SetController {


    @Autowired
    private SetDao setDao;

    @Autowired
    private ExerciseDao exerciseDao;

    //begin handlers

    //list sets handler
    @RequestMapping(value="")
    public String index(Model model) {
        model.addAttribute("Sets", setDao.findAll());
        model.addAttribute("title", "Sets");
        return "set/index";
    }

    //handler to display add Set form
    //use @PathVariable to pull in exercise ID from URL
    @GetMapping(value="add/{exId}")
    public String addSet(Model model, @PathVariable int exId) {

        //Exercise exercise = exerciseDao.findOne(exId);
        model.addAttribute("title", "Add Set");
        model.addAttribute(new Sets());
        model.addAttribute("sets", exerciseDao.findOne(exId));
        return "set/add";

    }

    //process and add new Set object
    @RequestMapping(value="add/{exId}", method = RequestMethod.POST)
    public String processSet(@ModelAttribute Sets newSet, Model model, @PathVariable int exId) {
        //initialize empty array list to hold multiple sets
        List<Sets> SetList = new ArrayList<Sets>();
        for(int i=0;i<6;i++){
            SetList.add(newSet);

        }

        //add set(s) to list
        //pull sets from list and save each one to DB

        //pull exercise ID
        Exercise exercise = exerciseDao.findOne(exId);
        model.addAttribute("title", "Add Set - " + exercise.getName());
        newSet.setExercise(exercise);
        setDao.save(newSet);
        model.addAttribute("Sets", setDao.findById(exId));
        model.addAttribute("exId", exId);


        return "set/index";
    }


}
