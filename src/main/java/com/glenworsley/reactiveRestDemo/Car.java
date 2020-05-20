package com.glenworsley.reactiveRestDemo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Car {

    @Id
    private String id;
    private String make;
    private String model;
    private String registration;
}
