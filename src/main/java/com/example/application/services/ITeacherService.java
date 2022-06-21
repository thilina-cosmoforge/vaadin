package com.example.application.services;

import com.example.application.domain.Teacher;
import com.example.application.domain.TeacherSearchCriteria;
import com.vaadin.flow.component.html.Image;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ITeacherService {
  //   List<Teacher> save(List<Teacher> teachers);

    Teacher save(Teacher teacher);

    List<Teacher> save(List<Teacher> teachers);

    Long getSavedStudentId();

    List<Teacher> search(TeacherSearchCriteria criteria);

    List<Teacher> search(com.example.application.domain.search.TeacherSearchCriteria criteria);

    Teacher search(Teacher teacher);

    List<Teacher> update(List<Teacher> teachers);

    Teacher update(Teacher teacher);

    List<Teacher> delete(List<Teacher> teachers);

    Teacher delete(Teacher teacher);

//    List<Teacher> searchByColumns(TeacherSearchCriteria criteria);


    //List<Teacher> searchByColumns(com.example.application.domain.search.TeacherSearchCriteria criteria);

    @Transactional
    List<Teacher> searchByColumns(TeacherSearchCriteria criteria);

    @Transactional
    List<Teacher> searchByColumns(com.example.application.domain.search.TeacherSearchCriteria criteria);

    List<Teacher> findAll();


    Teacher findBy(Long id);

    @Transactional
    Optional<Teacher> findByTeacherId(String no);

    void save(com.example.application.entity.Teacher teacher);


}
