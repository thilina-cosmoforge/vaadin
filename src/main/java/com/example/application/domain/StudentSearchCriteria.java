package com.example.application.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class StudentSearchCriteria  {

    private String firstName;
    private String middleName;
    private String surName;
    private String id;
    private String admissionNumber;
    private String gradeCategory;
    private String filterCriteria;
}
