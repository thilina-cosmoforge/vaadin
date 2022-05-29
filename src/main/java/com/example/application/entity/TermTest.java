package com.example.application.entity;

import com.example.application.AbstractEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.Year;
import java.util.List;

@Data
@Entity(name = "STUDENT_TERM_TEST")
public class TermTest extends AbstractEntity {
    @Column(name = "TERM")
    private String term;

    @Column(name = "YEAR")
    @Transient
    private Year year;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GRADE_ID")
    private Integer gradeId;

    @Column(name = "RANKING")
    private String ranking;
    @Column(name = "TOTAL_MARKS")
    private Double totalMarks;
    @Column(name = "AVERAGE_MARKS")
    private Double averageMarks;
    @Column(name = "SECTION_TYPE")
    private String sectionType;
    @Column(name = "FINAL_RESULT")
    private Character finalResult;

    @ManyToOne (cascade=CascadeType.ALL)
    private Student students;

    @ManyToMany
    @JoinTable(
            name = "SUB_TERM",
            joinColumns = @JoinColumn(name = "TERM"),
            inverseJoinColumns = @JoinColumn(name = "SUBJECT_ID"))
    List<Subject> subjects;

    @OneToMany(mappedBy="termTests",cascade=CascadeType.ALL)
    private List<Grade> grades;
}