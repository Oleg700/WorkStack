package org.workstack.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.workstack.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String name);

    @EntityGraph(value = "user-graph", type = EntityGraph.EntityGraphType.LOAD)
    List<User> findAll();
}
