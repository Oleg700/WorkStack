package org.workstack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
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

    @PrePersist
    public void prePersist(){
        if(publicationDate == null){
            publicationDate = LocalDate.now();
        }
    }
}
