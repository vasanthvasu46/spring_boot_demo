package com.swagger.service;

import com.swagger.customexception.EmptyDbException;
import com.swagger.customexception.EmptyFieldException;
import com.swagger.entity.Students;
import com.swagger.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Students> getAllStudents() {
        List<Students> studentsList = new ArrayList<>();
        studentRepository.findAll().forEach(studentsList::add);

        if (studentsList.isEmpty()) {
            throw new EmptyDbException("No records in database");
        }

        return studentsList;
    }

    public Students getByStudentId(int id) {
        Optional<Students> students = studentRepository.findById(id);
        if (!students.isPresent()) {
            throw new NoSuchElementException("No record with given id : " + id + " is found in database");
        }
        Students student = students.get();
        return student;

    }

    public Students addStudent(Students student) {
        if (student.getName().isEmpty()) {
            throw new EmptyFieldException("Please give student name");
        }
        if (student.getGender().isEmpty()) {
            throw new EmptyFieldException("Please give student gender");
        }
        if (student.getGrade().isEmpty()) {
            throw new EmptyFieldException("Please give student grade");
        }
        studentRepository.save(student);
        return student;
    }

    public void deleteByStudentId(int id) {
        Optional<Students> students = studentRepository.findById(id);
        if (!students.isPresent()) {
            throw new NoSuchElementException("No record with given id : " + id + " is found in database");
        }
        studentRepository.deleteById(id);
    }
}
