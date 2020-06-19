package org.workstack.model;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Set;
import java.util.SortedSet;

@Getter
@Setter
@Entity
@Table(name = "users")
@NamedEntityGraph(name = "user-graph",
        attributeNodes = {
                @NamedAttributeNode(value = "resume"),
                @NamedAttributeNode(value = "roles"),
                @NamedAttributeNode(value = "articles", subgraph = "comments")},
        subgraphs = @NamedSubgraph(name = "comments", attributeNodes = @NamedAttributeNode("comments")))

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private String city;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OrderBy("id")
    private SortedSet<Article> articles;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Resume resume;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;
}
