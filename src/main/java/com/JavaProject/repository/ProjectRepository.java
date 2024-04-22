package com.JavaProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JavaProject.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {

}