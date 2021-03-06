package launchcode.org.ExerciseTracker.models.data;

import launchcode.org.ExerciseTracker.models.wSession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

//Data Access Object - Interface that allows us to access cheese classes and interact with the DB.  This class touches the DB, we don't.
//crud repository class specifies methods that will allow us to send and retrieve data from DB
@Transactional //all methods should be wrapped into one transaction
@Repository
public interface wSessionDao extends CrudRepository<wSession, Integer> {
    List<wSession> findAllByOrderByIdDesc();
    wSession findByName (String name);
    wSession findById (Integer id);



}