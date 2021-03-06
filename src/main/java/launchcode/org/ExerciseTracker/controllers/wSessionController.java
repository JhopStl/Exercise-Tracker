package launchcode.org.ExerciseTracker.controllers;

import launchcode.org.ExerciseTracker.models.User;
import launchcode.org.ExerciseTracker.models.data.AuthenticationFacade;
import launchcode.org.ExerciseTracker.models.data.ExerciseDao;
import launchcode.org.ExerciseTracker.models.data.wSessionDao;
import launchcode.org.ExerciseTracker.models.service.UserService;
import launchcode.org.ExerciseTracker.models.wSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "session")
public class wSessionController {


    //@Autowired gives an instance of the wSessionDao class by the framework
    @Autowired
    wSessionDao wSessionDao;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationFacade authenticationFacade;
    
    //handler to list workout sessions (times went to the gym)
    //Will return all the Sessions in the database
    //links view to wSessiondao
    @RequestMapping(value="")
    public String index(Model model) {
        model.addAttribute("wSessions", wSessionDao.findAll());
      model.addAttribute("title", "Sessions");
      return "wSession/index";

    }

    //handler to display add wSession form
    //get request
    @RequestMapping(value="add", method = RequestMethod.GET)
    public String addSession(Model model) {

        //uses the Authentication class to call a method that finds active user
        Authentication authentication = authenticationFacade.getAuthentication();
        User activeUser = userService.findUserByEmail(authentication.getName());

        //send username to view
        model.addAttribute("username", "User " + activeUser.getUserName());
        model.addAttribute("title", "What are you working out today?");
        model.addAttribute(new wSession());
        return "wSession/add";
    }
    //creates a new wSession object and saves it to DB
    @RequestMapping(value="add", method = RequestMethod.POST)
    public String processSession(@ModelAttribute wSession newWSession, Model model) {

        //save session to DB
        //first tie user to session
        //User user = userService.findUserById(userId);

        //Pull active user ID
        Authentication authentication = authenticationFacade.getAuthentication();
        User activeUser = userService.findUserByEmail(authentication.getName());
        int userId = activeUser.getId();
        newWSession.setUser(activeUser);
        wSessionDao.save(newWSession);
        //grab id of new session
       int seshId = newWSession.getId();
       //need to grab user Id
        model.addAttribute("title", "Add Session");
        //redirects to the exercise controller and passes the wSession ID
        return "redirect:/" + seshId + "/exercise/add/";
    }

    //views session page (when user clicks on session URL, they are directed to new page)
    //page to view details about session
    @RequestMapping(value="view/{SessionId}", method = RequestMethod.GET)
    public String viewSession(Model model, @PathVariable int SessionId) {

       // pull a session ID by making an instance of the wSession class and calling DAO to pull the sessionId
        wSession session = wSessionDao.findOne(SessionId);
        model.addAttribute("title", session.getName());

        return "wSession/view";
    }
}
