package com.ovct.lms.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.util.List;

@Getter
@Setter
@Where(clause = "isDeleted = 0")
@Entity
@NoArgsConstructor
public class Grade extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private int number;

    @OneToMany(mappedBy = "grade")
    private List<Course> courses;
}
