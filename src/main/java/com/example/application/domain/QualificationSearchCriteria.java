package com.example.application.domain;


import lombok.Data;

@Data
public class QualificationSearchCriteria {

    private String id;
    private String qAdmissionNumber;
    private Integer year;
    private String qualificationType;
}
