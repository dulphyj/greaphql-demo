package com.graphql.graphql.service;

import com.graphql.graphql.entities.Students;

import java.util.List;

public interface IStudentsService {
    Students getStudentById(Long id);
    List<Students> getAllStudents();
    void saveStudent(Students student);
    void deleteStudent(Long id);
}
