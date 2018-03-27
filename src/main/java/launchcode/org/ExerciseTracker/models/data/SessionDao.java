package launchcode.org.ExerciseTracker.models.data;

import launchcode.org.ExerciseTracker.models.Session;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

//Data Access Object - Interface that allows us to access cheese classes and interact with the DB.  This class touches the DB, we don't.
//crud repository class specifies methods that will allow us to send and retrieve data from DB

@Repository
@Transactional //all methods should be wrapped into one transaction
public interface SessionDao extends CrudRepository<Session,Integer> {

}
