package com.example.application.repository;

import com.example.application.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ParentRepository extends JpaRepository<Parent, Long>, JpaSpecificationExecutor<Parent> {

}
