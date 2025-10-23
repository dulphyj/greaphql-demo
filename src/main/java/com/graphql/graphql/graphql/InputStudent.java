package com.graphql.graphql.graphql;

import lombok.Data;

@Data
public class InputStudent {
    private long id;
    private String name;
    private String lastName;
    private int age;
    private String courseId;
}
