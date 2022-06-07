package com.example.application;

import com.example.application.domain.Teacher;
import com.example.application.repository.TeacherRepository;
import com.example.application.services.ITeacherService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherTest {

    @Autowired
    public ITeacherService teacherService;

    @Autowired
    public TeacherRepository teacherRepository;

    @Test
    public void testTeacherSave(){
        Teacher teacher = new Teacher();
        teacher.setId(10L);
        teacher.setFirstName("Nimal");
        teacher.setMiddleName("Kumara");
        teacher.setSurName("jayaseundara");
        teacher.setNicNumber("9852635464V");
        teacher.setTeacherId("T001");
        teacher.setTeacherGrade("Grade 10");
        teacher.setTeacherContact("0123456789");
        teacher.setAddressStreet1("kalegana");
        teacher.setAddressStreet2("galle");
        teacher.setAddressDistrict("galle");

        teacher = teacherService.save(teacher);
        Assert.assertNotNull(teacher);
        Assert.assertNotNull(teacher.getId()>0);
    }
    @Test
    public void updateTeacherTest(){
        com.example.application.entity.Teacher teacher= teacherRepository.findById(23L).get();
        teacherRepository.delete(teacher);
        // teacherRepository.deleteById(46L);
        Teacher teacher1 = null;
        Optional<com.example.application.domain.Teacher> optionalTeacher = teacherRepository.findByFirstName("Nimal");
        if(optionalTeacher.isPresent()){
            teacher1 = optionalTeacher.get();
        }
        Assertions.assertNotNull(teacher);
    }
}
