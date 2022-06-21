package com.example.application.domain.search;


import lombok.Data;

@Data
public class TeacherSearchCriteria {
    private String id;
    private String nicNumber;
    private String firstName;
    private String middleName;
    private String surName;
    private String filterCriteria;

}
