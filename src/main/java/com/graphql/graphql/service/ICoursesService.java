package com.graphql.graphql.service;

import com.graphql.graphql.entities.Courses;

import java.util.List;

public interface ICoursesService {
    Courses getCourseById(Long id);
    List<Courses> getAllCourses();
    void saveCourse(Courses course);
    void deleteCourse(Long id);
}
