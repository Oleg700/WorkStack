package org.workstack.service.resume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workstack.model.Resume;
import org.workstack.repository.ResumeRepository;

import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {

    private ResumeRepository resumeRepository;

    @Autowired
    public ResumeServiceImpl(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    @Override
    public List<Resume> findAll() {
        return resumeRepository.findAll();
    }

    @Override
    public Resume save(Resume resume) {
        return resumeRepository.save(resume);
    }
}
