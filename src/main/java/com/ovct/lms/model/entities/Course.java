package com.ovct.lms.model.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ovct.lms.utill.enums.CourseStatus;
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
public class Course extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Subject subject;

    @ManyToOne
    private Grade grade;

    @ManyToOne
    private Teacher teacher;

    @OneToMany(mappedBy = "course")
    private List<Schedule> schedules;

    @JsonManagedReference
    @OneToMany(mappedBy = "course")
    private List<CourseInstructor> courseInstructors;

    @JsonManagedReference
    @OneToMany(mappedBy = "course")
    private List<CourseAssistant> courseAssistants;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CourseStatus courseStatus;
}
