package com.example.demo.student;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentResponse save(StudentDto dto){
        var student = studentMapper.toStudent(dto);
        var savedStudent = studentRepository.save(student);
        return studentMapper.toStudentResponse(savedStudent);
    }

    public StudentResponse findById(Integer id){
        var student = studentRepository.findById(id).orElse(new Student());
        return  studentMapper.toStudentResponse(student);
    }

    public List<StudentResponse> findAll(){
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toStudentResponse)
                .collect(Collectors.toList());
    }

    public List<StudentResponse> findByFirstName(String firstName){
        return studentRepository.findAllByFirstNameContainingIgnoreCase(firstName)
                .stream()
                .map(studentMapper::toStudentResponse)
                .collect(Collectors.toList());
    }
}
