package launchcode.org.ExerciseTracker.controllers;

import launchcode.org.ExerciseTracker.models.Session;
import launchcode.org.ExerciseTracker.models.data.SessionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "session")
public class SessionController {


    //@Autowired gives an instance of the SessionDao class by the framework
    @Autowired
    private SessionDao sessionDao;

    //handler to list workout sessions (times went to the gym)
    //Will return all the Sessions in the database
    //links view to Workoutdao
    @RequestMapping(value="")
    public String index(Model model) {
        model.addAttribute("sessions", sessionDao.findAll());
      model.addAttribute("title", "Sessions");
      return "session/index";

    }

    //handler to display add session form
    //get request
    @RequestMapping(value="add", method = RequestMethod.GET)
    public String addSession(Model model) {

        model.addAttribute("title", "Add Session");
        model.addAttribute(new Session());
        return "session/add";
    }
    //creates a new Session object and saves it to DB
    @RequestMapping(value="add", method = RequestMethod.POST)
    public String processSession(@ModelAttribute Session newSession, Model model) {

        model.addAttribute("title", "Add Session");

        //save workout to DB
        sessionDao.save(newSession);
        return "redirect:";
    }

    //views session page (when user clicks on session URL, they are directed to new page)
    //@RequestMapping(value="view/{sessionId}", method = RequestMethod.GET)
    //public String viewSession(Model model, @PathVariable int id) {

        //pull a session ID by making an instance of the session/workout class and calling DAO
        //Workout workout = WorkoutDao.findOne(id);

        //return "workout/view";
    //}
}
