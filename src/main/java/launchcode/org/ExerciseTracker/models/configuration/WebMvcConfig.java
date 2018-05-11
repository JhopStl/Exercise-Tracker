package launchcode.org.ExerciseTracker.models.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration //Indicates that the class can be used by Inversion of Control container as a source of bean definitions (allows for dependency injections)
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Bean //tells spring that a method with this annotation will return an object that needs to be registered as a bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
}
