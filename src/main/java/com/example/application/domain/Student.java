package com.example.application.domain;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Student extends AbstractModel {

    private String admissionNumber;

    private String firstName;
    private String middleName;
    private String surName;

    private String nameInitials;
    private LocalDate dateOfBirth;
    private String religion;
    private String nationality;
    private String house;
    private Long insuranceNumber;
    private String formerSchool;
    private String gradeCategory;
    private Float distance;
    private String modeTransmission;
    private Long birthCertificateNumber;

    private String addressStreet1;
    private String addressStreet2;
    private String addressDistrict;

    private LocalDate admissionDate;
    private String admissionGrade;

    private String extraActivityYear;
    private String extraActivities;
    private String extraActivityStatus;

    private byte[] picture;
    private Parent parents;
    private List<TermTest> termTests;
    private List<Qualification> qualifications;
    private Grade grades;
    private ClassCategory classCategories;
    List<Teacher> teachers;
}


