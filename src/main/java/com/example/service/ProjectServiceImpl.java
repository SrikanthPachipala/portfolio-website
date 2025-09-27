package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Project;
import com.example.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private final ProjectRepository projectRepo;

    public ProjectServiceImpl(ProjectRepository projectRepo) {
        this.projectRepo = projectRepo;
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }

    @Override
    public Project saveProject(Project project) {
        return projectRepo.save(project);
    }

}
