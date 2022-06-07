package com.example.application.services;

import com.example.application.domain.Teacher;
import com.example.application.repository.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
@Service
public class TeacherService implements ITeacherService{

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    public ModelMapper modelMapper;

    public static  byte[] getBytesFromFile(String imagePath) throws IOException {
        File file = new File(imagePath);
        return Files.readAllBytes(file.toPath());
    }


    @Override
    public Teacher save(Teacher teacher) {
        com.example.application.entity.Teacher saveTeacher = modelMapper.map(teacher,com.example.application.entity.Teacher.class);
        saveTeacher =teacherRepository.save(saveTeacher);
        return modelMapper.map(saveTeacher, Teacher.class);
    }
    @Override
    public Teacher update(Teacher teacher) {
        com.example.application.entity.Teacher updateStudent = modelMapper.map(teacher, com.example.application.entity.Teacher.class);
        teacherRepository.saveAndFlush(updateStudent);
        return modelMapper.map(updateStudent, Teacher.class);
    }


}
