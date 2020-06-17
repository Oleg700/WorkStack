package org.workstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.workstack.model.Resume;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {
}