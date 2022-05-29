package com.example.application.entity;
import com.example.application.AbstractEntity;
import com.example.application.enums.ContactDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "PARENT_CONTACTS")
public class ParentContact extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "TEL_FIXED")
    private ContactDetail fixed;

    @Enumerated(EnumType.STRING)
    @Column(name = "TEL_MOBILE")
    private ContactDetail mobile;

    @Enumerated(EnumType.STRING)
    @Column(name = "EMAIL")
    private ContactDetail email;
}