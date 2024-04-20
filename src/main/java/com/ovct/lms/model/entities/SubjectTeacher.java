package com.ovct.lms.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class SubjectTeacher extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JsonBackReference
    private Subject subject;

    @ManyToOne
    @JsonBackReference
    private Teacher teacher;

    private int priorExperience;

    @OneToMany(mappedBy = "subjectTeacher")
    private List<Qualification> qualifications;
}
