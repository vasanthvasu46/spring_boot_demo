package GlobalExceptionHandling.Service;

import GlobalExceptionHandling.CustomException.EmptyDBException;
import GlobalExceptionHandling.CustomException.EmptyInputFieldsException;
import GlobalExceptionHandling.Model.Students;
import GlobalExceptionHandling.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Students> getStudentsList()
    {
        List<Students> students=new ArrayList<>();

        studentRepository.findAll().forEach(students::add);
        if(students.isEmpty())
        {
            throw new EmptyDBException("601","No records found in Db");
        }
        return students;
    }

    public Students getStudentById(int id)
    {

        return studentRepository.findById(id).get();
    }

    public Students addStudent(Students student)
    {

        if(student.getId()==0)
        {
            throw new EmptyInputFieldsException("602","Id field is empty");
        }
        if(student.getName().isEmpty() || student.getName().length()==0 )
        {
            throw new EmptyInputFieldsException("602","Name field is empty");
        }
        if(student.getAge()==0)
        {
            throw new EmptyInputFieldsException("602","Age field is empty");
        }
        studentRepository.save(student);
        return student;
    }

    public void deleteStudent(int id)
    {
        studentRepository.deleteById(id);
    }

}
