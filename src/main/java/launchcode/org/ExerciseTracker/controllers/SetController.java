package launchcode.org.ExerciseTracker.controllers;

import launchcode.org.ExerciseTracker.models.Sets;
import launchcode.org.ExerciseTracker.models.data.SetDao;
import launchcode.org.ExerciseTracker.models.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping (value = "set")
public class SetController {


    @Autowired
    private SetDao setDao;

    //begin handlers

    //list sets handler
    @RequestMapping(value="")
    public String index(Model model) {
        model.addAttribute("Sets", setDao.findAll());
        model.addAttribute("title", "Sets");
        return "set/index";
    }

    //handler to display add Set form
    @RequestMapping(value="add", method = RequestMethod.GET)
    public String addSet(Model model) {
        model.addAttribute("title", "Add Set");
        model.addAttribute(new Sets());
        return "set/add";

    }

    //process and add new Set object
    @RequestMapping(value="add", method = RequestMethod.POST)
    public String processSet(@ModelAttribute Sets newSet, Model model) {
        model.addAttribute("title", "Add Set");
        setDao.save(newSet);

        return "redirect:";
    }


}
