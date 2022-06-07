package com.example.application.services;

import com.example.application.domain.Teacher;

import java.util.List;

public interface ITeacherService {
  //   List<Teacher> save(List<Teacher> teachers);

    Teacher save(Teacher teacher);

    Teacher update(Teacher teacher);
}
