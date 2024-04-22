package com.example.demo_thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_thymeleaf.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {

}