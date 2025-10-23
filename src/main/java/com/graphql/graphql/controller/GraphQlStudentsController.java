package com.graphql.graphql.controller;

import com.graphql.graphql.entities.Courses;
import com.graphql.graphql.entities.Students;
import com.graphql.graphql.graphql.InputStudent;
import com.graphql.graphql.service.ICoursesService;
import com.graphql.graphql.service.IStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQlStudentsController {
    @Autowired
    private IStudentsService studentsService;
    @Autowired
    private ICoursesService coursesService;

    @QueryMapping(name = "findStudentById")
    public Students findStudentById(@Argument String id) {
        Long studentId = Long.parseLong(id);
        return studentsService.getStudentById(studentId);
    }

    @QueryMapping(name = "findAllStudents")
    public List<Students> findAllStudents() {
        return studentsService.getAllStudents();
    }

    @MutationMapping(name = "createStudent")
    public Students saveStudent(@Argument(name = "studentInput") InputStudent inputStudent){
        Courses course = coursesService.getCourseById(Long.parseLong(inputStudent.getCourseId()));

        Students students = new Students();
        students.setName(inputStudent.getName());
        students.setLastName(inputStudent.getLastName());
        students.setAge(inputStudent.getAge());
        students.setCourse(course);

        studentsService.saveStudent(students);

        return students;
    }
}
