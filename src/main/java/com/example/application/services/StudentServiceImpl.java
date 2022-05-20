package com.example.application.services;

import com.example.application.entity.Student;
import com.example.application.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> getAllActiveStudents(){
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id){
        return studentRepository.findById(id);
    }
}
