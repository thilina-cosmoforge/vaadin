package com.example.application.entity;
import com.example.application.AbstractEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "QUALIFICATION")
public class Qualification extends AbstractEntity {

    @Column(name = "Q_ADMISSION_NUMBER")
    private String qAdmissionNumber;
    @Column(name = "YEAR")
    private Integer year;
    @Column(name = "MARKS")
    private Double marks;
    @Column(name = "FINAL_GRADE")
    private String finalGrade;
    @Column(name = "QUALIFICATION_TYPE")
    private String type;

    @ManyToOne
    private Student students;
    @ManyToMany
    @JoinTable(
            name = "Q_SUBJECT",
            joinColumns = @JoinColumn(name = "Q_ADMISSION_NUMBER"),
            inverseJoinColumns = @JoinColumn(name = "ADMISSION_NUMBER"))
    List<Subject> subjects;
    @ManyToMany(mappedBy = "qualifications")
    List<Grade> grades;
}