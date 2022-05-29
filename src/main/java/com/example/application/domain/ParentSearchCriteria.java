package com.example.application.domain;

import lombok.Data;

@Data
public class ParentSearchCriteria {

    private String id;
    private String nicNumber;
    private String firstName;
    private String middleName;
    private String surName;
    private String filterCriteria;
}
