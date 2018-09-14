package launchcode.org.ExerciseTracker.controllers;

import launchcode.org.ExerciseTracker.models.Exercise;
import launchcode.org.ExerciseTracker.models.Forms.SetForm;
import launchcode.org.ExerciseTracker.models.Sets;
import launchcode.org.ExerciseTracker.models.data.ExerciseDao;
import launchcode.org.ExerciseTracker.models.data.SetDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;



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
    //defining SetListForm object.  Allows access to the setlistForm object in view
//    @ModelAttribute("setForm")
//    public SetForm populateSets() {
//        //initialize the Sets list
//        SetForm setForm = new SetForm();
//        ArrayList<Sets> setsList = new ArrayList<Sets>();
//
//        //creates empty Sets objects
//        int count = setsList.size();
//        for (int i=0; i< count + 1; i++) {
//            setsList.add(new Sets());
//        }
//        setForm.setSetsList(setsList);
//        return setForm;
//    }
//
//
//
//    @RequestMapping(value ="add/{exId}", method=RequestMethod.POST)
//    public String saveSetForm(@ModelAttribute("setForm") SetForm setForm, Model model, @PathVariable int exId){
//        for(Sets sets : setForm.getSetsList()) {
//            //Create a new exercise from the ID that has pulled via URL (using @PathVariable to pull)
//            Exercise exercise = exerciseDao.findOne(exId);
//            model.addAttribute("title", "Add Set - " + exercise.getName());
//            //for each set, tie that to the new ;exercise that was created above
//            sets.setExercise(exercise);
//            setDao.save(sets);
//            model.addAttribute("Sets", setDao.findById(exId));
//            model.addAttribute("exId", exId);
//        }
//        return "set/index";
//    }

    //process and add new Set object
    @RequestMapping(value="add/{exId}", method = RequestMethod.POST)
    public String processSet(@ModelAttribute Sets newSet, Model model, @PathVariable int exId) {

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
