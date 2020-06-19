package org.workstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.workstack.model.Resume;
import org.workstack.service.resume.ResumeService;

import java.util.List;

@RestController
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @GetMapping(value = "/resumes")
    public List<Resume> getAll() {
        return resumeService.findAll();
    }

    @PostMapping(value = "/resumes")
    public Resume save(@RequestBody Resume resume) {
        return resumeService.save(resume);
    }
}
