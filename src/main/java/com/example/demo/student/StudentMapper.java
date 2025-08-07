package com.example.demo.student;

import com.example.demo.school.School;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student toStudent(StudentDto dto){
        Student student = new Student();
        student.setEmail(dto.email());
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        School school = new School();
        school.setId(dto.schoolId());
        student.setSchool(school);
        return student;
    }
    public StudentResponse toStudentResponse(Student student){
        return new StudentResponse(student.getFirstName(),student.getLastName(),student.getEmail());
    }
}
