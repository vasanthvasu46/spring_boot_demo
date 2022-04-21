package com.swagger.controller;

import com.swagger.entity.Students;
import com.swagger.service.StudentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "Get all students from dataBase", notes = "Returns all students details from the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - No record found in database")
    })
    @GetMapping("/students")
    public ResponseEntity<List<Students>> getAllStudents() {
        List<Students> studentsList = studentService.getAllStudents();
        return new ResponseEntity<List<Students>>(studentsList, HttpStatus.OK);
    }

    @ApiOperation(value = "Get a student from database", notes = "Returns a student as per the id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - No record found in database from get by id")
    })
    @GetMapping("/student")
    public ResponseEntity<Students> getByStudentId(@RequestParam int id) {
        Students student = studentService.getByStudentId(id);
        return new ResponseEntity<Students>(student, HttpStatus.OK);
    }

    @ApiOperation(value = "Add student to database", notes = "ID field is auto generated. Don't need to fill ID field")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully created"),
            @ApiResponse(code = 404, message = "Fill all fields")
    })
    @PostMapping("/student")
    public ResponseEntity<Students> addStudent(@RequestBody Students student) {
        studentService.addStudent(student);
        return new ResponseEntity<Students>(student, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Delete student", notes = "Delete a student from database based on given id")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfull"),
            @ApiResponse(code = 404, message = "Not found - No record found in database")
    })
    @DeleteMapping("/student")
    public ResponseEntity<String> deleteStudentById(@RequestParam int id) {
        studentService.deleteByStudentId(id);
        return new ResponseEntity<String>("Deleted", HttpStatus.OK);
    }
}
