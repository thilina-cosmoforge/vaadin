package com.example.application.domain;

import com.example.application.enums.ContactDetail;
import lombok.Data;

@Data
public class TeacherContact {
    private ContactDetail fixed;
    private ContactDetail mobile;
}
