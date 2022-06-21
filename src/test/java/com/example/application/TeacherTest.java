package com.example.application;

import com.example.application.domain.TeacherContact;
import com.example.application.entity.Teacher;
import com.example.application.repository.TeacherRepository;
import com.example.application.services.ITeacherContactService;
import com.example.application.services.ITeacherService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class TeacherTest {

    @Autowired
    ITeacherService teacherService;
    @Autowired
    ITeacherContactService teacherContactService;
    @Autowired
    public TeacherRepository teacherRepository;

    @Test
    public void testTeacherSave(){
        com.example.application.domain.Teacher teacher = com.example.application.domain.Teacher.builder()
                .teacherId("1111")
                .nicNumber("3345353534")
                .firstName("Nilani")
                .middleName("Chandra")
                .surName("Rathnayeke")
                .nameWithInitials("N.C.Rathnayeke")
                .addressStreet1("N0.23")
                .addressStreet2("street junction")
                .addressDistrict("Galle")
                .teacherGrade("5")
                .appointedSubject("")
                .firstAppointDate(LocalDate.parse("2002-02-18"))
                .dateAssumingSchool(LocalDate.parse("2002-04-08"))
                .build();
        teacherService.save(teacher);
//        TeacherContact teacherContact1 = TeacherContact.builder()
//                .type(ContactDetail.MOBILE)
//                .value("0764445556")
//                .teacher(teacherService.findBy((long)1))
//                .build();
//        TeacherContact teacherContact2 = TeacherContact.builder()
//                .type(ContactDetail.EMAIL)
//                .value("teacher@email.com")
//                .teacher(teacherService.findBy((long)1))
//                .build();
//        teacherContactService.save(teacherContact1);
//        teacherContactService.save(teacherContact2);
    }

    @Test
    public void updateTeacherTest(){
        com.example.application.entity.Teacher teacher  = teacherRepository.findById(22L).get();
        teacher.setFirstName("Hansi");
        com.example.application.entity.Teacher teacherUpdated =  teacherRepository.save(teacher);
        Assertions.assertNotNull(teacherUpdated.getTeacherId());
    }

    @Test
    public void deleteTeacherTest(){
        com.example.application.entity.Teacher teacher = teacherRepository.findById(23L).get();
        teacherRepository.delete(teacher);
        // teacherRepository.deleteById(46L);
        com.example.application.domain.Teacher teacher1 = null;
        Optional<com.example.application.domain.Teacher> optionalTeacher = teacherRepository.findByFirstName("Gayathri");
        if(optionalTeacher.isPresent()){
            teacher1 = optionalTeacher.get();
        }
        Assertions.assertNotNull(teacher);
    }

    @Test
    public void getOneTeacherTest() {
        Optional<com.example.application.domain.Teacher> teacher = teacherService.findByTeacherId("555");
        System.out.println("teacher = " + teacher );
    }

    @Test
    public void getListTeacherTest() {
        List<com.example.application.domain.Teacher> teachers = teacherService.findAll();
        System.out.println("Size :" + teachers.size());
    }
}
