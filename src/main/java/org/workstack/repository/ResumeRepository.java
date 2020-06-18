package org.workstack.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.workstack.model.Resume;

import java.util.List;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {

    @EntityGraph(value = "resume-graph", type = EntityGraph.EntityGraphType.LOAD)
    List<Resume> findAll();
}
