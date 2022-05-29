package com.example.application.entity.weak;

import lombok.Data;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
@AttributeOverrides(
        {
                @AttributeOverride(
                        name = "year",
                        column = @Column(name = "EXTRA_ACTIVITY_YEAR")
                ),
                @AttributeOverride(
                        name = "activity",
                        column = @Column(name = "EXTRA_ACTIVITIES")
                ),
                @AttributeOverride(
                        name = "status",
                        column = @Column(name = "EXTRA_ACTIVITY_STATUS")
                )
        }
)
public class ExtraCurricularActivities {

    private String year;
    private String activity;
    private String status;
}