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
    @Column(name = "TYPE")
    private ContactDetail type;

    @Column(name = "VALUE")
    private String value;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "teacher_id", referencedColumnName = "ID")
    private Teacher teacher;
}