package com.microservice.course.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Table(name = "course")
@AllArgsConstructor
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    private Long id;
    @ToString.Include
    private String name;
    @ToString.Include
    private String teacher;
}
