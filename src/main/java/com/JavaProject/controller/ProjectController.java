package com.example.demo_thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo_thymeleaf.service.ProjectService;

@Controller
public class ProjectController {
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listProjects", projectService.getAllProjects());
        return "index_project";
    }

    @GetMapping("/addProject")
    public String showAddProjectPage() {
        return "add_project";
    }
}