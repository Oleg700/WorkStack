package org.workstack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

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

    @OneToOne
    @JoinColumn(name = "id")
    @JsonIgnore
    private User user;

    private String description;
}
