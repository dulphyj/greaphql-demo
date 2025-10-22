package com.graphql.graphql.persistence;

import com.graphql.graphql.entities.Students;
import org.springframework.data.repository.CrudRepository;

public interface IStudentsDAO extends CrudRepository<Students, Long>{
}
