package com.example.demo.student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {
    @Mock
    StudentRepository studentRepository = mock(StudentRepository.class);
    @Mock
    StudentMapper studentMapper = mock(StudentMapper.class);

    @Test
    public void should_save_student(){
        StudentDto studentDto = new StudentDto("Priyanshu", "Sharma","p@gmail.com",1);
        Student student = new Student("Priyanshu","Sharma","p@gmail.com",21);

        when(studentRepository.save(student)).thenReturn(student);
        when(studentMapper.toStudent(studentDto)).thenReturn(student);
        when(studentMapper.toStudentResponse(student)).thenReturn(new StudentResponse("Priyanshu","Sharma","p@gmail.com"));

        var savedStudent = studentRepository.save(student);
        Assertions.assertEquals(savedStudent,student);
    }
}