package com.example.application.repository;

import com.example.application.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
@EnableJpaRepositories
public interface TeacherRepository  extends JpaRepository<Teacher, Long>, JpaSpecificationExecutor<Teacher> {
    Optional<com.example.application.domain.Teacher> findByFirstName(String firstName);
    Teacher findByFirstNameLike(String chars);

    @Query(" select t.teacherId from TEACHER t where t.firstName = ?1 ")
    String getReligionByFirstName(String name);
}
