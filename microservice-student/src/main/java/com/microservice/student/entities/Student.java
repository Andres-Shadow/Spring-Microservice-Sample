package com.microservice.student.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;


@Entity
@Builder
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    private Long id;
    @ToString.Include
    private String name;
    @ToString.Include
    private String lastname;
    @ToString.Include
    private String email;
    @Column(name = "course_id")
    @ToString.Include
    private Long courseID;
}
