package com.example.application.entity.weak;
import lombok.Data;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
@AttributeOverrides({
        @AttributeOverride(
                name = "firstName",
                column = @Column(name = "FIRST_NAME")
        ),
        @AttributeOverride(
                name = "middleName",
                column = @Column(name = "MIDDLE_NAME")
        ),
        @AttributeOverride(
                name = "surName",
                column = @Column(name = "SUR_NAME")
        )
})
public class FullName {

    private String firstName;
    private String middleName;
    private String surName;
}