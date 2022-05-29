package com.example.application.generator;

import com.example.application.repository.ParentRepository;
import com.example.application.repository.StudentRepository;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@SpringComponent
public class DataGenerator {

    @Bean
    public CommandLineRunner loadData(StudentRepository studentRepository, ParentRepository parentRepository) {
        return args -> {
            Logger logger = LoggerFactory.getLogger(getClass());
            if (studentRepository.count() != 0L){
                logger.info("");
                return;
            }
            int seed = 123;

            logger.info("Generating Demo data");

        };
    }


}