package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.service.ProjectService;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // display list of Projects
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listProjects", projectService.getAllProjects());
        return "index";
    }

    @GetMapping("/addProject")
    public String showAddProjectPage() {
        return "add_project";
    }
}