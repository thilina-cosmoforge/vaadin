package com.example.application.domain;

import lombok.Data;

import java.util.List;

@Data
public class Grade extends AbstractModel {

    private String subjectId;
    private String studentId;
    private String admissionNumber;
    private String year;
    private String termTestDetails;
    private String subWiseGrade;
    private String otherGrade;
    private Student students;
    private Subject subjects;
    private TermTest termTests;
    private ClassCategory gradeCategories;
    List<Qualification> qualifications;
}