package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/add-student")
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        studentService.addStudent(student);

        //String response = studentService.addStudent(student);

        return new ResponseEntity<>("New Student added successfully", HttpStatus.CREATED);
    }

    @PostMapping(("/add-teacher"))
    public ResponseEntity<String> addTeacher(@RequestBody Teacher teacher){
        studentService.addTeacher(teacher);

        return new ResponseEntity<>("New Teacher added successfully", HttpStatus.CREATED);
    }

    @PutMapping("/add-student-teacher-pair")
    public ResponseEntity<String> addStudentTeacherPair(@RequestParam("student")String student, @RequestParam("teacher")String teacher){
        studentService.createStudentTeacherPair(student, teacher);

        return new ResponseEntity<>("New student-teacher pair added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get-student-by-name/{name}")
    public ResponseEntity<Student> getStudentByName(@PathVariable String name){


        Student student = studentService.findStudent(name);

        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }

    @GetMapping("/get-teacher-by-name/{name}")
    public ResponseEntity<Teacher> getTeacherByName(@PathVariable String name){


        Teacher teacher = studentService.findTeacher(name);

        return new ResponseEntity<>(teacher,HttpStatus.CREATED);
    }

    @GetMapping("/get-students-by-teacher-name/{teacher}")
    public ResponseEntity<List<String>> getStudentsByTeacherName(@PathVariable String teacher){
        List<String> student = studentService.findStudentFromTeacher(teacher);

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-students")
    public ResponseEntity<List<String>> getAllStudents(){
        List<String> student = studentService.findAllStudent();

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("/delete-teacher-by-name")
    public ResponseEntity<String> deleteTeacherByName(@RequestParam String teacher){
        studentService.deleteTeacher(teacher);

        return new ResponseEntity<>(teacher + "remove successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-teachers")
    public ResponseEntity<String> deleteAllTeacher (){
        studentService.deleteAllTeacher();

        return new ResponseEntity<>("All teachers delete successfully", HttpStatus.CREATED);
    }
}
//add something