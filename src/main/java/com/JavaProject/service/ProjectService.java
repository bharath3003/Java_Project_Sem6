package com.JavaProject.service;

import java.util.List;

import com.JavaProject.dto.ProjectDto;
import com.JavaProject.entity.Project;

public interface ProjectService {
    List<ProjectDto> getAllProjects();

    ProjectDto convertToDto(Project project);
}