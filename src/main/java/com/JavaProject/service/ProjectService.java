package com.JavaProject.service;

import com.JavaProject.entity.Project;
import com.JavaProject.entity.Project.DomainName;
import com.JavaProject.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(int id) {
        return projectRepository.findById(id);
    }

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    public void deleteProjectById(int id) {
        projectRepository.deleteById(id);
    }

    public List<Project> getProjectsByDomain(DomainName domain) {
        return projectRepository.findByDomain(domain);
    }

}
