package org.workstack.service.resume;

import org.springframework.beans.factory.annotation.Autowired;
import org.workstack.model.Resume;
import org.workstack.repository.ResumeRepository;

public class ResumeServiceImpl implements ResumeService {

    private ResumeRepository resumeRepository;

    @Autowired
    public ResumeServiceImpl(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    @Override
    public void saveResume(Resume resume) {
        resumeRepository.save(resume);
    }
}
