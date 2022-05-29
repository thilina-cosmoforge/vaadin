package com.example.application.entity;

import com.example.application.AbstractEntity;
import com.example.application.enums.ContactDetail;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TEACHER_CONTACTS")
public class TeacherContact extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "TEL_FIXED")
    private ContactDetail fixed;

    @Enumerated(EnumType.STRING)
    @Column(name = "TEL_MOBILE")
    private ContactDetail mobile;
}