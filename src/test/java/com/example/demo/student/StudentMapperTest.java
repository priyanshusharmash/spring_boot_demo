package com.example.demo.student;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentMapperTest {

    private StudentMapper studentMapper;

    @BeforeEach
    public void setup(){
        studentMapper = new StudentMapper();
    }

    @Test
    public void studentDtoToStudentTest(){
        StudentDto dto = new StudentDto("Priyanshu","Sharma","ps@gmail.com",1);
        Student student = studentMapper.toStudent(dto);
        Assertions.assertEquals(dto.firstName(),student.getFirstName());
        Assertions.assertEquals(dto.lastName(),student.getLastName());
        Assertions.assertEquals(dto.email(),student.getEmail());
        Assertions.assertNotNull(student.getSchool());
    }

    @Test
    public void shouldMapStudentToStudentResponse(){
        Student student = new Student("Priyanshu","Sharma","p@gmail.com",20);
        StudentResponse studentResponse = studentMapper.toStudentResponse(student);
        Assertions.assertEquals(student.getFirstName(),studentResponse.firstName());
        Assertions.assertEquals(student.getLastName(),studentResponse.lastName());
        Assertions.assertEquals(student.getEmail(),studentResponse.email());
    }
}