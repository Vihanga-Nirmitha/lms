package com.ovct.lms.model.entity;

import com.ovct.lms.utill.enums.ScheduleType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Where(clause = "isDeleted = 0")
@Entity
@NoArgsConstructor
public class Schedule extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Course course;

    private LocalTime startTime;

    private LocalTime endTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ScheduleType scheduleType;

    private LocalDate startDate;

    @Column(columnDefinition = "tinyint(1) default 0")
    private boolean isActive;
}
