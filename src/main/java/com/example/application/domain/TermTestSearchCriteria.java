package com.example.application.domain;

import lombok.Data;

@Data
public class TermTestSearchCriteria {
    private String id;
    private String term;
    private Integer yearly;
    private String sectionType;
}
