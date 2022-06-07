package com.example.application.entity;
import com.example.application.AbstractEntity;
import com.example.application.entity.weak.Address;
import com.example.application.entity.weak.FullName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@Entity(name = "TEACHER")
public class Teacher extends AbstractEntity {

    @Column(name = "TEACHER_ID", unique = true)
    private String teacherId;
    @Column(name = "NIC_NUMBER", unique = true)
    private String nicNumber;

    @Column(name = "NAME_WITH_INITIALS")
    private String nameWithInitials;

    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "MIDDLE_NAME")
    private String middleName;
    @Column(name = "SUR_NAME")
    private String surName;

    @Column(name = "ADDRESS_DISTRICT")
    private String addressStreet1;
    @Column(name = "ADDRESS_STREET1")
    private String addressStreet2;
    @Column(name = "ADDRESS_STREET2")
    private String addressDistrict;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "NIC_NUMBER")
    private Set<TeacherContact> teacherContacts;

    @Column(name = "TEACHER_GRADE")
    private String teacherGrade;
    @Column(name = "APPOINTED_SUBJECT")
    private String appointedSubject;
    @Column(name = "FIRST_APPOINT_DATE")
    private LocalDate firstAppointDate;
    @Column(name = "DATE_ASSUMING_SCHOOL")
    private LocalDate dateAssumingSchool;
    @Column(name = "DATE_PENSION")
    private LocalDate datePension;

    @ManyToMany(mappedBy = "teachers")
    List<Student> students;

    @ManyToMany(mappedBy = "teachers")
    List<Subject> subjects;
}