package com.example.application.domain.weak;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class FullName {

    private String firstName;
    private String middleName;
    private String surName;
}