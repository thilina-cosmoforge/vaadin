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
                        name = "district",
                        column = @Column(name = "ADDRESS_DISTRICT")
                ),
                @AttributeOverride(
                        name = "street1",
                        column = @Column(name = "ADDRESS_STREET1")
                ),
                @AttributeOverride(
                        name = "street2",
                        column = @Column(name = "ADDRESS_STREET2")
                )
        }
)
public class Address {

    private String street1;
    private String street2;
    private String district;
}