package com.example.demo_thymeleaf.service;

import java.util.List;

import com.example.demo_thymeleaf.dto.ProjectDto;
import com.example.demo_thymeleaf.model.Project;

public interface ProjectService {
    List<ProjectDto> getAllProjects();

    ProjectDto convertToDto(Project project);
}