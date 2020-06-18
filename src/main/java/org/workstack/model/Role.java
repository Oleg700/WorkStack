package org.workstack.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
}
