package com.example.application.services;

import com.example.application.domain.Parent;
import com.example.application.repository.ParentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentService implements IParentService{
    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    public ModelMapper modelMapper;

    @Override
    public Parent save(Parent parent){
        com.example.application.entity.Parent saveParent = modelMapper.map(parent, com.example.application.entity.Parent.class);
        saveParent = parentRepository.save(saveParent);
        return modelMapper.map(saveParent, Parent.class);
    }
}
