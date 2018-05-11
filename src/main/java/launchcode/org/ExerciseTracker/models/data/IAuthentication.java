package launchcode.org.ExerciseTracker.models.data;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

public interface IAuthentication {
    Authentication getAuthentication();
}

