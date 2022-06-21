package com.example.application.domain;

import com.example.application.domain.TeacherContact;
import com.example.application.enums.ContactDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherContact extends AbstractModel {

    private ContactDetail type;
    private String value;
    private Teacher teacher;
}
