package com.example.application.services;

import com.example.application.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService  {

   void saveStudent(Student student);

    List<Student> getAllActiveStudents();

    Optional<Student> getStudentById(Long id);
}
