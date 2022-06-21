package com.example.application.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public class IdFinder {
    @Column(name = "User_ID", unique = true)
    private String userId;

}
