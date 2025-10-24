package com.graphql.graphql.controller;

import com.graphql.graphql.entities.Courses;
import com.graphql.graphql.graphql.CourseInput;
import com.graphql.graphql.service.ICoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQlCoursesController {
    @Autowired
    ICoursesService coursesService;

    @QueryMapping(name = "findCourseById")
    public Courses findCourseById(@Argument String id) {
        Long courseId = Long.parseLong(id);
        return coursesService.getCourseById(courseId);
    }

    @QueryMapping(name = "findAllCourses")
    public List<Courses> findAllCourses() {
        return coursesService.getAllCourses();
    }

    @MutationMapping(name = "createCourse")
    public Courses createCourse(@Argument CourseInput courseInput) {
        Courses courses = new Courses();
        courses.setName(courseInput.getName());
        courses.setCategory(courseInput.getCategory());
        courses.setTeacher(courseInput.getTeacher());
        coursesService.saveCourse(courses);
        return courses;
    }

    @MutationMapping(name = "deleteCourse")
    public String deleteCourse(@Argument String id){
        Long courseId = Long.parseLong(id);
        coursesService.deleteCourse(courseId);
        return "Course deleted successfully";

    }
}
