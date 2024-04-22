package com.example.demo_thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import com.example.demo_thymeleaf.service.ProjectService;
import com.example.demo_thymeleaf.model.Project;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // display list of Projects
    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Project> list = projectService.getAllProjects();
        for (Project fruit : list)
            System.out.println(fruit);
        model.addAttribute("listProjects", projectService.getAllProjects());
        return "index";
    }

    @GetMapping("/addProject")
    public String showAddProjectPage() {
        return "add_project";
    }
}