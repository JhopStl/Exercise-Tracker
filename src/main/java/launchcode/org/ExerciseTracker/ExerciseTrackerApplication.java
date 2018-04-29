package launchcode.org.ExerciseTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ExerciseTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExerciseTrackerApplication.class, args);
	}
}
