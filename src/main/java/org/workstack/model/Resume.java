package org.workstack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Table
@NamedEntityGraph(name = "resume-graph",
        attributeNodes = {
                @NamedAttributeNode(value = "user")
        })
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "job_position")
    private String jobPosition;

    private String description;

    @OneToOne
    @JoinColumn(name = "id")
    @JsonIgnore
    private User user;


}
