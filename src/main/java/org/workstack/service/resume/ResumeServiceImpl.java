package org.workstack.service.resume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.workstack.model.Resume;
import org.workstack.model.User;
import org.workstack.repository.ResumeRepository;
import org.workstack.repository.UserRepository;

import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {

    private ResumeRepository resumeRepository;

    private UserRepository userRepository;

    @Autowired
    public ResumeServiceImpl(ResumeRepository resumeRepository, UserRepository userRepository) {
        this.resumeRepository = resumeRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Resume> findAll() {
        return resumeRepository.findAll();
    }

    @Override
    public Resume save(Resume resume, String username) {
        User user = userRepository.findByUsername(username);
        resume.setId(user.getId());
        resume.setUser(user);
        return resumeRepository.save(resume);
    }
}
