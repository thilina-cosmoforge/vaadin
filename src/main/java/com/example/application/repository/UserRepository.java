package com.example.application.repository;

import com.example.application.entity.ImageUser;
import com.example.application.entity.Teacher;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository   extends JpaRepository<ImageUser, Long>, JpaSpecificationExecutor<ImageUser> {
    @EntityGraph(attributePaths={"profilePicture"})
    ImageUser findWithPropertyPictureAttachedById(Long id);
}
