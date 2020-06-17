package org.workstack.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table
public class Article {

    @Id
    private long id;

    private String topic;

    private String content;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments;
}
