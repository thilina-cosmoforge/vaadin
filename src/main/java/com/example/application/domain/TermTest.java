package com.example.application.domain;

import lombok.Data;

import java.util.List;

@Data
public class TermTest extends AbstractModel{

    private String term;
    private Integer yearly;
    private Integer gradeId;
    private String ranking;
    private Double totalMarks;
    private Double averageMarks;
    private String sectionType;
    private String finalResult;
    private Student students;
    List<Grade> grades;
    List<Subject> subjects;







}
