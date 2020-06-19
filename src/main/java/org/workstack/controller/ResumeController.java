package org.workstack.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.workstack.model.Resume;
import org.workstack.model.dto.ResumeDto;
import org.workstack.service.resume.ResumeService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/resumes")
    public List<Resume> getAll() {
        return resumeService.findAll();
    }

    @PostMapping(value = "/resumes")
    public Resume save(@Valid @RequestBody ResumeDto resumeDto, Principal principal) {
        Resume resume = modelMapper.map(resumeDto, Resume.class);
        String username = principal.getName();
        return resumeService.save(resume, username);
    }
}
