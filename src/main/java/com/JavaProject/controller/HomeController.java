package com.JavaProject.controller;
import java.util.List;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.JavaProject.repository.UserRepo;
import com.JavaProject.entity.User;
import com.JavaProject.service.UserService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.JavaProject.repository.RequestsRepo;
import com.JavaProject.entity.Requests;
import jakarta.servlet.http.HttpSession;
import com.JavaProject.service.RequestService;


@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RequestsRepo requestsRepo;

    @Autowired
    private RequestService requestService;


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
    @GetMapping("/user/inbox")
    public String inbox(Principal p, Model m) {
        String email = p.getName();
        User user = userRepo.findByEmail(email);
        m.addAttribute("user", user);
        List<Requests> requests = requestsRepo.findAll();
        // Add requests to the model
        m.addAttribute("requests", requests);
        return "inbox";
        
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

    @PostMapping("/inbox/acceptRequest")
    public String acceptRequest(@RequestParam("reqSender") String reqSender, @ModelAttribute("user") User user) {
        requestService.acceptRequest(reqSender, user.getEmail());
        return "redirect:/user/inbox";
    }

    @PostMapping("/inbox/rejectRequest")
    public String rejectRequest(@RequestParam("reqSender") String reqSender, @ModelAttribute("user") User user) {
        requestService.rejectRequestBySender(reqSender, user.getEmail());
        return "redirect:/user/inbox";
    }

}
