package com.example.application.domain;

import lombok.Data;

import java.util.List;

@Data
public class Subject extends AbstractModel{

    private String subjectId;
    private String name;
    private Integer gradeId;
    private List<Grade> grades;
    List<Qualification> qualifications;
    List<TermTest> termTests;
    List<Teacher> teachers;
}
