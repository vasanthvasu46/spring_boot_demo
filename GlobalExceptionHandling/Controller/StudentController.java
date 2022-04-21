package GlobalExceptionHandling.Controller;


import GlobalExceptionHandling.Model.Students;
import GlobalExceptionHandling.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<?> getStudents()
    {
        List<Students> students=studentService.getStudentsList();
        return new ResponseEntity<List<Students>>(students, HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<?> getStudentsById(@PathVariable int id)
    {
        Students student=studentService.getStudentById(id);
        return new ResponseEntity<Students>(student,HttpStatus.OK);
    }

    @PostMapping("/students")
    public ResponseEntity<?> addStudent(@RequestBody Students student)
    {
        Students s=studentService.addStudent(student);
        return new ResponseEntity<Students>(s,HttpStatus.OK);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<?> updateStudent(@RequestBody Students student)
    {
        Students s=studentService.addStudent(student);
        return new ResponseEntity<Students>(s,HttpStatus.OK);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable int id)
    {
        studentService.deleteStudent(id);
    }
}
