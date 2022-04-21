package CutsomExceptionHandling.Repository;

import CutsomExceptionHandling.Model.Movies;
import org.springframework.data.repository.CrudRepository;

public interface MoviesRepository extends CrudRepository<Movies, String> {

}
