package io.javabrains.Course;

import io.javabrains.Topics.Topics_class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    /*private List<Course_class> courses= new ArrayList<>(Arrays.asList(
            new Course_class("Spring_Boot",1,2000.0),
            new Course_class("JAVA",2,3000.0),
            new Course_class("ML",3,2000.0),
            new Course_class("DS",4,2500.0)
    ));*/

    public List<Course_class> getCourse(int topicId)
    {
        List<Course_class> courses =new ArrayList<>();

        courseRepository.findByTopicId(topicId).forEach(courses::add);

        return courses;
    }

    public Course_class getSpecificCourse(int course_id)
    {
        Optional<Course_class> optional=courseRepository.findById(course_id);

        return optional.get();
    }

    public void addCourse(Course_class course) {

        courseRepository.save(course);
    }

    public void updateCourse(Course_class course) {

        courseRepository.save(course);
    }

    public void deleteCourse(int course_id) {
        courseRepository.deleteById(course_id);
    }
}

