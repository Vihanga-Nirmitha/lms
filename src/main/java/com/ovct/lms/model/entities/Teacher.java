package com.ovct.lms.model.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ovct.lms.utill.enums.CourseStatus;
import com.ovct.lms.utill.enums.TeacherStatus;
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
public class Teacher extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long userId;

    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;

    @JsonManagedReference
    @OneToMany(mappedBy = "teacher")
    private List<SubjectTeacher> subjectTeachers;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TeacherStatus teacherStatus;

    @Column(columnDefinition = "tinyint(1) default 0")
    private boolean isActive;
}
