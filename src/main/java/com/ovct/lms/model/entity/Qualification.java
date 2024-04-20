package com.ovct.lms.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

@Getter
@Setter
@Where(clause = "isDeleted = 0")
@Entity
@NoArgsConstructor
public class Qualification extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    @ManyToOne
    private SubjectTeacher subjectTeacher;
}
