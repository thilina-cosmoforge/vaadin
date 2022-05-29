package com.example.application.domain;


import com.example.application.domain.weak.FullName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Parent extends AbstractModel {

    private String nicNumber;
    private String nameWithInitials;

    private String firstName;
    private String middleName;
    private String surName;

    private ParentContact parentContact;

    private String addressStreet1;
    private String addressStreet2;
    private String addressDistrict;

    private String occupation;
    private List<Student> students;
}




