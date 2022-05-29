package com.example.application.domain;

import lombok.Data;

import java.util.List;

@Data
public class ClassCategory extends AbstractModel {

    private String categoryId;
    private String year;
    private String categoryType;
    private Grade grades;
    List<Student> students;

}
