package com.example.application.repository;

import com.example.application.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {
    Optional<Student> findByFirstName(String firstName);
    Student findByFirstNameLike(String chars);

    @Query(" select s.religion from Student s where s.firstName = ?1 ")
    String getReligionByFirstName(String name);
}
