package com.example.application.domain;
import com.example.application.domain.weak.Address;
import com.example.application.domain.weak.FullName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Teacher extends AbstractModel {

    private String teacherId;
    private String nicNumber;
    private String nameWithInitials;


    private String firstName;
    private String middleName;
    private String surName;


    private String addressStreet1;
    private String addressStreet2;
    private String addressDistrict;

    private String teacherContact;

    private String teacherGrade;
    private String appointedSubject;
    private LocalDate firstAppointDate;
    private LocalDate dateAssumingSchool;
    private LocalDate datePension;
    List<Student> students;
    List<Subject> subjects;
}