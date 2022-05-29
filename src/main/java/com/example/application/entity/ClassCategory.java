package com.example.application.entity;


import com.example.application.AbstractEntity;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity(name = "STUDENT_CATEGORY")
public class ClassCategory extends AbstractEntity {

    @Column(name = "CATEGORY_ID")
    private String categoryId;
    @Column(name = "YEAR")
    private String year;
    @Column(name = "CATEGORY_TYPE")
    private String categoryType;

    @OneToMany(mappedBy = "classCategories", cascade = CascadeType.ALL)
    List<Student> students;
    @OneToMany(mappedBy="classCategories",cascade=CascadeType.ALL)
    List <Grade> grades ;

}
