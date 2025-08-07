package com.example.demo.student;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    private final StudentMapper studentMapper;
    private StudentService studentService;

    public StudentController(StudentService studentService, StudentMapper studentMapper) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
    }

    @PostMapping("/students")
    public StudentResponse save(
            @Valid @RequestBody StudentDto dto
    ){
        return studentService.save(dto);
    }


    @GetMapping("/students/{id}")
    public StudentResponse findById(
            @PathVariable("id") Integer id
    ){
        return studentService.findById(id);
    }

    @GetMapping("/students")
    public List<StudentResponse> findAll(){
        return  studentService.findAll();
    }

    @GetMapping("/students/search/{firstName}")
    public List<StudentResponse> findByName(
            @PathVariable("firstName") String firstName
    ){
        return studentService.findByFirstName(firstName);
    }


    @ExceptionHandler
    public ResponseEntity<?> handleException(MethodArgumentNotValidException ex){
        Map<String,String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach((e)->{
            errors.put(e.getField(),e.getDefaultMessage());
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
