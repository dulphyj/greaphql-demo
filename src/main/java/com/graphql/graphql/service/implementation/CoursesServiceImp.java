package com.graphql.graphql.service.implementation;

import com.graphql.graphql.entities.Courses;
import com.graphql.graphql.persistence.ICoursesDAO;
import com.graphql.graphql.service.ICoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CoursesServiceImp implements ICoursesService {
    @Autowired
    private ICoursesDAO coursesDAO;

    @Override
    @Transactional(readOnly = true)
    public Courses getCourseById(Long id) {
        return coursesDAO.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Courses> getAllCourses() {
        return (List<Courses>) coursesDAO.findAll();
    }

    @Override
    @Transactional
    public void saveCourse(Courses course) {
        coursesDAO.save(course);
    }

    @Override
    @Transactional
    public void deleteCourse(Long id) {
        coursesDAO.deleteById(id);
    }
}
