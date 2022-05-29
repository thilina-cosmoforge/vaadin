package com.example.application.entity;

import com.example.application.AbstractEntity;
import com.example.application.entity.weak.Address;
import com.example.application.entity.weak.ExtraCurricularActivities;
import com.example.application.entity.weak.FullName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student extends AbstractEntity {

    @Column(name = "ADMISSION_NUMBER", unique = true)
    private String admissionNumber;

    @Column(name = "ADMISSION_DATE")
    private LocalDate admissionDate;
    @Column(name = "ADMISSION_GRADE")
    private String admissionGrade;

    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "MIDDLE_NAME")
    private String middleName;
    @Column(name = "SUR_NAME")
    private String surName;


    @Column(name = "NAME_INITIALS")
    private String nameInitials;

    @Column(name = "DATE_OF_BIRTH")
    private LocalDate dateOfBirth;
    @Column(name = "RELIGION")
    private String religion;
    @Column(name = "NATIONALITY")
    private String nationality;
    @Column(name = "HOUSE")
    private String house;
    @Column(name = "INSURANCE_NUMBER")
    private Long insuranceNumber;
    @Column(name = "FORMER_SCHOOL")
    private String formerSchool;
    @Column(name = "GRADE_CATEGORY")
    private String gradeCategory;
    @Column(name = "DISTANCE")
    private Float distance;
    @Column(name = "MODE_of_TRANSMISSION")
    private String modeTransmission;
    @Column(name = "BIRTH_CERTIFICATE_NUMBER")
    private Long birthCertificateNumber;

    @Column(name = "ADDRESS_DISTRICT")
    private String addressStreet1;
    @Column(name = "ADDRESS_STREET1")
    private String addressStreet2;
    @Column(name = "ADDRESS_STREET2")
    private String addressDistrict;

    @Column(name = "EXTRA_ACTIVITY_YEAR")
    private String extraActivityYear;
    @Column(name = "EXTRA_ACTIVITIES")
    private String extraActivities;
    @Column(name = "EXTRA_ACTIVITY_STATUS")
    private String extraActivityStatus;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] picture;

    @ManyToOne
    private Parent parents;
    @OneToMany(mappedBy="students", cascade = CascadeType.ALL)
    private List<TermTest> termTests;
    @OneToMany(mappedBy = "students",cascade = CascadeType.ALL)
    private List<Qualification> qualifications;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "GRADE_ID", referencedColumnName = "ID")
    private Grade grades;
    @ManyToOne
    private ClassCategory classCategories;
    @ManyToMany
    @JoinTable(
            name = "STU_TEACHER",
            joinColumns = @JoinColumn(name = "STUDENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "TEACHER_ID"))
    List<Teacher> teachers;
}
