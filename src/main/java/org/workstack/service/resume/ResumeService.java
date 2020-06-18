package org.workstack.service.resume;

import org.workstack.model.Resume;

import java.util.List;

public interface ResumeService {

    List<Resume> findAll();

    Resume save(Resume resume);
}
