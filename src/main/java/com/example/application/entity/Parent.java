package com.example.application.entity;

import com.example.application.AbstractEntity;
import com.example.application.entity.weak.Address;
import com.example.application.entity.weak.FullName;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity(name = "PARENT")
public class Parent extends AbstractEntity {


    @Column(name = "NIC_NUMBER")
    private String nicNumber;
    @Column(name = "NAME_WITH_INITIALS")
    private String nameWithInitials;

    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "MIDDLE_NAME")
    private String middleName;
    @Column(name = "SUR_NAME")
    private String surName;

    @Column(name = "ADDRESS_DISTRICT")
    private String addressStreet1;
    @Column(name = "ADDRESS_STREET1")
    private String addressStreet2;
    @Column(name = "ADDRESS_STREET2")
    private String addressDistrict;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "NIC_NUMBER")
    private List<ParentContact> parentContacts;

    @Column(name = "OCCUPATION")
    private String occupation;

    @OneToMany(mappedBy = "parents",cascade = CascadeType.ALL)
    private List<Student> students;
}