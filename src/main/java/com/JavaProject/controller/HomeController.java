package com.JavaProject.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.JavaProject.repository.ProjectRepository;
import com.JavaProject.repository.UserRepo;
import com.JavaProject.entity.Project;
import com.JavaProject.entity.Project.DomainName;
import com.JavaProject.entity.User;
import com.JavaProject.service.ProjectService;
import com.JavaProject.service.UserService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectRepository projectRepository;

    @ModelAttribute
    public void commonUser(Principal p, Model m) {
        if (p != null) {
            String email = p.getName();
            User user = userRepo.findByEmail(email);
            m.addAttribute("user", user);
        }
    }

    @GetMapping("/")
    public String index(Principal principal) {
        if (principal != null) {
            return "redirect:/user/profile";
        }
        return "index";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/signin")
    public String login() {
        return "login";
    }

    @GetMapping("/user/profile")
    public String profile(Principal p, Model m) {
        String email = p.getName();
        User user = userRepo.findByEmail(email);
        m.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/user/projectdetails")
    public String projectdetails() {
        return "projectdetails";
    }
     @GetMapping("/user/projects")
    public String projects(Model model) {
        // Get all projects initially
        List<Project> allProjects = projectService.getAllProjects();
        model.addAttribute("allProjects", allProjects);

        // Return the projects.html template
        return "projects";
    }

    @PostMapping("/user/projects")
    public String projectsByDomain(@RequestParam("domain") DomainName domain, Model model) {
        // Get projects by domain
        List<Project> projectsByDomain = projectService.getProjectsByDomain(domain);
        model.addAttribute("allProjects", projectsByDomain); // Update model with filtered projects

        // Return the projects.html template
        return "projects";
    }



    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute User user, HttpSession session, Model m) {
        User u = userService.saveUser(user);
        if (u != null) {
            session.setAttribute("msg", "Registered successfully");
        } else {
            session.setAttribute("msg", "Server error");
        }
        return "redirect:/register";
    }
}