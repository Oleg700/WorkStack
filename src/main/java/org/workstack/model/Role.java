package org.workstack.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
public class Role {

    @Id
    private long id;

    private String name;
}
