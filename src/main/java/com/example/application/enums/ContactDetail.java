package com.example.application.enums;

import lombok.Getter;

@Getter
public enum ContactDetail {
    MOBILE("Mobile Number"),
    FIXED("Fixed Telephone Number"),
    EMAIL("Email Address");

    private final String value;
    ContactDetail(String value) {
        this.value= value;
    }

}
