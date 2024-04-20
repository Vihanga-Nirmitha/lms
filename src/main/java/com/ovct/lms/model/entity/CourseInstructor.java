package com.ovct.lms.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class CourseInstructor extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JsonBackReference
    private Instructor instructor;

    @ManyToOne
    @JsonBackReference
    private Course course;

    @Column(columnDefinition = "tinyint(1) default 0")
    private boolean isActive;
}
