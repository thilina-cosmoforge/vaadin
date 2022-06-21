package com.example.application.repository;


import com.example.application.entity.ParentContact;
import com.example.application.entity.TeacherContact;
import com.example.application.entity.TeacherContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TeacherContactRepository extends JpaRepository<TeacherContact, Long>, JpaSpecificationExecutor<ParentContact> {
}
