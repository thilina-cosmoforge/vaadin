package com.example.application.domain;

import lombok.Data;

import java.util.List;

@Data
public class Qualification extends AbstractModel {

    private String qAdmissionNumber;
    private Integer year;
    private Double marks;
    private String finalGrade;
    private String qualificationType;
    private Student students;
    List<Subject> subjects;
    List<Grade> grades;

}