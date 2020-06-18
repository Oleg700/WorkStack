package org.workstack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table
@NamedEntityGraph(name = "article-graph",
        attributeNodes = {
                @NamedAttributeNode(value = "comments"),
                @NamedAttributeNode(value = "user", subgraph = "resume")},
        subgraphs = @NamedSubgraph(name = "resume", attributeNodes = @NamedAttributeNode("resume")))


public class Article implements Comparable<Article> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String topic;

    private String content;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "article_id")
    private List<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Override
    public int compareTo(Article article) {
        return Long.compare(this.id, article.id);
    }
}
