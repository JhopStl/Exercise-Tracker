package launchcode.org.ExerciseTracker.controllers;

import launchcode.org.ExerciseTracker.models.data.ExerciseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "exercise")
public class ExerciseController {

    @Autowired
    private ExerciseDao exerciseDao;
}
