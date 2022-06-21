package com.example.application.services;

import com.example.application.domain.Teacher;
import com.example.application.domain.search.TeacherSearchCriteria;
import com.example.application.repository.TeacherRepository;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.server.StreamResource;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherService implements ITeacherService{
    @Autowired
    public TeacherRepository teacherRepository;
    @Autowired
    public ModelMapper modelMapper;

    private Long teacherID;

    public static byte[] getBytesFromFile(String imagePath) throws IOException {
        File file = new File(imagePath);
        return Files.readAllBytes(file.toPath());
    }
    @Override
    public Teacher save(Teacher teacher) {
        com.example.application.entity.Teacher saveTeacher = modelMapper.map(teacher, com.example.application.entity.Teacher.class);
        teacherID = saveTeacher.getId();

        saveTeacher = teacherRepository.save(saveTeacher);
        return modelMapper.map(saveTeacher, Teacher.class);

    }

    @Override
    public List<Teacher> save(List<Teacher> teachers) {
        List<com.example.application.entity.Teacher> saveTeachers = teachers.stream().map(t -> modelMapper.map(t, com.example.application.entity.Teacher.class)).collect(Collectors.toList());
        saveTeachers.forEach(teacher -> teacherRepository.save(teacher));
        return saveTeachers.stream().map(teacher -> modelMapper.map(teacher, Teacher.class)).collect(Collectors.toList());
    }
    @Override
    public Long getSavedStudentId(){
        return teacherID;
    }
    @Override
    public List<Teacher> search(com.example.application.domain.TeacherSearchCriteria criteria) {
        List<com.example.application.entity.Teacher> teachers = teacherRepository.findAll((root, cq, cb) -> {
            List<javax.persistence.criteria.Predicate> predicates = new ArrayList<>();
            if (!StringUtils.isBlank(criteria.getNicNumber())) {
                predicates.add(cb.like(root.get("nicNumber"), criteria.getNicNumber() + "%"));
            }

            if (!StringUtils.isBlank(criteria.getId())) {
                predicates.add(cb.like(root.get("id"), criteria.getId() + "%"));
            }

            if (!StringUtils.isBlank(criteria.getFirstName())) {
                predicates.add(cb.like(root.get("firstName"), criteria.getFirstName() + "%"));
            }

            if (!StringUtils.isBlank(criteria.getMiddleName())) {
                predicates.add(cb.like(root.get("middleName"), criteria.getMiddleName() + "%"));
            }

            if (!StringUtils.isBlank(criteria.getSurName())) {
                predicates.add(cb.like(root.get("surName"), criteria.getSurName() + "%"));
            }

            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        });
        return teachers.stream().map(teacher-> modelMapper.map(teacher, Teacher.class)).collect(Collectors.toList());
    }

    @Override
    public Teacher search(Teacher teacher) {
        com.example.application.entity.Teacher searchTeacher = modelMapper.map(teacher, com.example.application.entity.Teacher.class);
        teacherRepository.findAll();
        return modelMapper.map(searchTeacher, Teacher.class);
    }
    @Override
    public List<Teacher> search(TeacherSearchCriteria criteria) {
        return null;
    }


    @Override
    public List<Teacher> update(List<Teacher> teachers) {
        List<com.example.application.entity.Teacher> updateTeacher = teachers.stream().map(student -> modelMapper.map(teachers, com.example.application.entity.Teacher.class)).collect(Collectors.toList());
        updateTeacher.forEach(teacher -> teacherRepository.saveAndFlush(teacher));
        return updateTeacher.stream().map(teacher -> modelMapper.map(teacher, Teacher.class)).collect(Collectors.toList());
    }

    @Override
    public Teacher update(Teacher teacher) {
        com.example.application.entity.Teacher updateTeacher = modelMapper.map(teacher, com.example.application.entity.Teacher.class);
        teacherRepository.saveAndFlush(updateTeacher);
        return modelMapper.map(updateTeacher, Teacher.class);
    }

    @Override
    public List<Teacher> delete(List<Teacher> teachers) {
        List<com.example.application.entity.Teacher> deleteTeacher = teachers.stream().map(teacher -> modelMapper.map(teacher, com.example.application.entity.Teacher.class)).collect(Collectors.toList());
        deleteTeacher.forEach(teacher -> teacherRepository.delete(teacher));
        return deleteTeacher.stream().map(teacher -> modelMapper.map(teacher, Teacher.class)).collect(Collectors.toList());
    }

    @Override
    public Teacher delete(Teacher teacher) {
        com.example.application.entity.Teacher deleteTeacher = modelMapper.map(teacher, com.example.application.entity.Teacher.class);
        teacherRepository.delete(deleteTeacher);
        return modelMapper.map(deleteTeacher, Teacher.class);
    }


    public List<Teacher> searchByColumns(com.example.application.domain.TeacherSearchCriteria criteria) {
        return null;
    }


    @Transactional
    @Override
    public List<Teacher> searchByColumns(TeacherSearchCriteria criteria) {
        List<com.example.application.entity.Teacher> teachers = teacherRepository.findAll((root, cq, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (!StringUtils.isBlank(criteria.getFilterCriteria())) {
                predicates.add(cb.like(root.get("firstName"), criteria.getFilterCriteria() + "%"));
            }
            if (!StringUtils.isBlank(criteria.getFilterCriteria())) {
                predicates.add(cb.like(root.get("middleName"), criteria.getFilterCriteria() + "%"));
            }
            if (!StringUtils.isBlank(criteria.getFilterCriteria())) {
                predicates.add(cb.like(root.get("surName"), criteria.getFilterCriteria() + "%"));
            }

            return cb.or(predicates.toArray(new Predicate[predicates.size()]));
        });
        return teachers.stream().map(teacher -> modelMapper.map(teacher, Teacher.class)).collect(Collectors.toList());
    }

    @Override
    public List<Teacher> findAll() {
       List<com.example.application.entity.Teacher> teachers = teacherRepository.findAll();
       return teachers.stream().map(teacher -> modelMapper.map(teacher,Teacher.class)).collect(Collectors.toList());
    }


    @Transactional
    @Override
    public Teacher findBy(Long id) {
        Optional<com.example.application.entity.Teacher> teacherResponse = teacherRepository.findById(id);
        return teacherResponse.map(parent -> modelMapper.map(parent, Teacher.class)).orElse(null);
    }
    @Transactional
    @Override
    public Optional<Teacher> findByTeacherId(String no) {
        Optional<com.example.application.entity.Teacher> studentResponse = teacherRepository.findByTeacherId(no);
        return studentResponse.map(teacher -> modelMapper.map(teacher, Teacher.class));
    }
    @Override
    public void save(com.example.application.entity.Teacher teacher) {

    }


    public Image generateImage(Teacher teacher){
        Long id = teacher.getId();
        StreamResource sr = new StreamResource("user", () ->  {
            com.example.application.entity.Teacher attached = teacherRepository.findWithPropertyPictureAttachById(id);
            return new ByteArrayInputStream(attached.getPicture());
        });
        sr.setContentType("image/png");
        Image image = new Image(sr, "profile-picture");
        return image;
    }

}
