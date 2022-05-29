package com.example.application.repository;

import com.example.application.domain.Parent;
import com.example.application.domain.ParentContact;
import com.example.application.enums.ContactDetail;
import com.example.application.services.ParentService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ParentRepositoryTest {

    @Autowired
    public ParentRepository parentRepository;

    @Autowired
    public ParentService parentService;

    @Test
    public void saveParent(){

        ParentContact parentContact = ParentContact.builder()
                .fixed(ContactDetail.TEL_FIXED)
                .mobile(ContactDetail.TEL_MOBILE)
                .email(ContactDetail.EMAIL)
                .build();

        Parent parent = Parent.builder()
                .nicNumber("1234")
                .nameWithInitials("ert")
                .firstName("ee")
                .middleName("rr")
                .surName("tt")
                .parentContact(parentContact)
                .addressStreet1("we")
                .addressStreet2("ew")
                .addressDistrict("Galle")
                .occupation("ghtyyuij")
                .build();
        parentService.save(parent);
    }
}