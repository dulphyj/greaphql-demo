package com.graphql.graphql.persistence;

import com.graphql.graphql.entities.Courses;
import org.springframework.data.repository.CrudRepository;

public interface ICoursesDAO extends CrudRepository<Courses, Long> {
}
