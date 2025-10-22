package com.graphql.graphql.service.implementation;

import com.graphql.graphql.entities.Students;
import com.graphql.graphql.persistence.IStudentsDAO;
import com.graphql.graphql.service.IStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentsServiceImp implements IStudentsService {
    @Autowired
    private IStudentsDAO studentsDAO;

    @Override
    @Transactional(readOnly = true)
    public Students getStudentById(Long id) {
        return studentsDAO.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Students> getAllStudents() {
        return (List<Students>) studentsDAO.findAll();
    }

    @Override
    @Transactional
    public void saveStudent(Students student) {
        studentsDAO.save(student);
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        studentsDAO.deleteById(id);
    }
}
