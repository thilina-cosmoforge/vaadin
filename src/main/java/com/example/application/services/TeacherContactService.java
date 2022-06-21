package com.example.application.services;



import com.example.application.domain.TeacherContact;
import com.example.application.repository.TeacherContactRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherContactService implements ITeacherContactService{
    @Autowired
    public TeacherContactRepository teacherContactRepository;

    @Autowired
    public ModelMapper modelMapper;

    @Override
    public TeacherContact save(TeacherContact teacherContact) {
        com.example.application.entity.TeacherContact saveContact = modelMapper.map(teacherContact, com.example.application.entity.TeacherContact.class);
        teacherContactRepository.save(saveContact);
        return modelMapper.map(saveContact, TeacherContact.class);
    }
}
