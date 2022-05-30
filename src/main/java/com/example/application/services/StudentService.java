package com.example.application.services;

import com.example.application.domain.Student;
import com.example.application.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    public ModelMapper modelMapper;

    public static byte[] getBytesFromFile(String imagePath) throws IOException {
        File file = new File(imagePath);
        return Files.readAllBytes(file.toPath());
    }


    @Override
    @Transactional
    public Student save(Student student) {
        com.example.application.entity.Student saveStudent = modelMapper.map(student, com.example.application.entity.Student.class);
        saveStudent = studentRepository.save(saveStudent);
        return modelMapper.map(saveStudent, Student.class);
    }
}
