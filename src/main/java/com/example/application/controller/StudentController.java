package com.example.application.controller;

import com.example.application.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller
public class StudentController {

    @Value("${uploadDir}")
    private String uploadFolder;

    @Autowired
    private IStudentService IStudentService;
}
