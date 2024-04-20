package com.ovct.lms.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractEntity {

    @CreationTimestamp
    @Column(name = "created_date", updatable = false, columnDefinition = "DATETIME(0)")
    @ColumnDefault("CURRENT_TIMESTAMP")
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name = "last_modified_date", updatable = false, columnDefinition = "DATETIME(0)")
    @ColumnDefault("CURRENT_TIMESTAMP")
    private LocalDateTime lastModifiedDate;

    @Column(columnDefinition = "tinyint(1) default 0")
    private boolean isDeleted;
}
