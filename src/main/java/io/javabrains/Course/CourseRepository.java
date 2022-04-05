package io.javabrains.Course;

import io.javabrains.Topics.Topics_class;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course_class, Integer> {

    public List<Course_class> findByTopicId(int topicId);


}
