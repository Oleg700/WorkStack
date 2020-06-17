package org.workstack.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
public class Resume {

    @Id
    private long id;

    @Column(name = "job_position")
    private String jobPosition;

    private String description;
}
