package org.workstack.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
public class Comment {

    @Id
    private long id;

    private String content;
}
