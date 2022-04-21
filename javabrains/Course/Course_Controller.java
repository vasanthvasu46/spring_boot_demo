package io.javabrains.Course;


import io.javabrains.Topics.Topics_class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Course_Controller {

    @Autowired
    private CourseService courseService;

    @GetMapping("/topics/{topicId}/courses")
    public List<Course_class> getAllCourses(@PathVariable int topicId)
    {
        return courseService.getCourse(topicId);
    }

    @GetMapping("/topics/{id}/courses/{course_id}")
    public Course_class getSpecificCourse(@PathVariable int course_id)
    {
        return courseService.getSpecificCourse(course_id);
    }

    @PostMapping(value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course_class course, @PathVariable int topicId)
    {
        course.setTopic(new Topics_class("",topicId,0.0));
        courseService.addCourse(course);
    }

    @PutMapping(value = "/topics/{topicId}/courses/{course_id}")
    public void updateCourse(@RequestBody Course_class course,@PathVariable int topicId,@PathVariable int course_id)
    {
        course.setTopic(new Topics_class("",topicId,0.0));
        courseService.updateCourse(course);
    }

    @DeleteMapping(value = "/topics/{id}/courses/{course_id}")
    public void deleteCourse(@PathVariable int course_id)
    {
        courseService.deleteCourse(course_id);
    }
}
