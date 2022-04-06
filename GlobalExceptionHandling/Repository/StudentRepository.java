package GlobalExceptionHandling.Repository;

import GlobalExceptionHandling.Model.Students;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Students, Integer> {
}
