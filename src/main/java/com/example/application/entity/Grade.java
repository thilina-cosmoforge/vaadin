package com.example.application.entity;
import com.example.application.AbstractEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "GRADE")
public class Grade extends AbstractEntity {

    @Column(name = "ADMISSION_NUMBER")
    private String admissionNumber;
    @Column(name = "SUBJECT_ID")
    private String subjectId;
    @Column(name = "STUDENT_ID")
    private String studentId;

    @Column(name = "YEAR")
    private String year;
    @Column(name = "TERM_TEST_DETAILS")
    private String termTestDetails;
    @Column(name = "SUB_WISE_GRADE")
    private String subWiseGrade;
    @Column(name = "OTHER_GRADE")
    private String otherGrade;

    @OneToOne(mappedBy = "grades")
    private Student students;
    @ManyToOne (cascade=CascadeType.ALL)
    private ClassCategory classCategories;
    @ManyToOne (cascade=CascadeType.ALL)
    private Subject subjects;
    @ManyToOne (cascade=CascadeType.ALL)
    private TermTest termTests;
    @ManyToMany
    @JoinTable(
            name = "GRA_QUAL",
            joinColumns = @JoinColumn(name = "GRADE_ID"),
            inverseJoinColumns = @JoinColumn(name = "Q_ADMISSION_NUMBER"))
    List<Qualification> qualifications;
}