package com.graphql.graphql.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "students")
@Data
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @Column(name = "last_name")
    private String lastName;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Courses.class)
    private Courses course;
}
