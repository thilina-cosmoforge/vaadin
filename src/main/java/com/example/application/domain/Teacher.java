package com.example.application.domain;
import com.example.application.domain.weak.Address;
import com.example.application.domain.weak.FullName;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Teacher extends AbstractModel {

    private String teacherId;
    private String nicNumber;
    private String nameWithInitials;

    private FullName fullName;

    private Address address;

    private TeacherContact teacherContact;

    private String teacherGrade;
    private String appointedSubject;
    private LocalDate firstAppointDate;
    private LocalDate dateAssumingSchool;
    private LocalDate datePension;
    List<Student> students;
    List<Subject> subjects;
}