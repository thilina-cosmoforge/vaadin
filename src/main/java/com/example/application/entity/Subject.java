package com.example.application.entity;

import com.example.application.AbstractEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "SUBJECT")
public class Subject extends AbstractEntity {

    @Column(name = "SUBJECT_ID")
    private String subjectId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "GRADE_ID")
    private Integer gradeId;

    @ManyToMany(mappedBy = "subjects")
    List<Qualification> qualifications;
    @ManyToMany(mappedBy = "subjects")
    List<TermTest> termTests;
    @ManyToMany
    @JoinTable(
            name = "SUB_TEACHER",
            joinColumns = @JoinColumn(name = "SUBJECT_ID"),
            inverseJoinColumns = @JoinColumn(name = "TEACHER_ID"))
    List<Teacher> teachers;
    @OneToMany(mappedBy="subjects",cascade=CascadeType.ALL)
    private List<Grade> grades;
}