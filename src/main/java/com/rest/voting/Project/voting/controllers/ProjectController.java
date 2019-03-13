package com.rest.voting.Project.voting.controllers;

import com.rest.voting.Project.voting.model.Project;
import com.rest.voting.Project.voting.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {
    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping(value = "/projects", produces = "application/json")
    public ResponseEntity<List<Project>> getProjects() {
        return ResponseEntity.ok().body(projectService.getProjects());
    }


    @GetMapping(value = "/project/{id}", produces = "application/json")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {

        return ResponseEntity.ok()
                .body(projectService.getProjectById(id));
    }

    @PatchMapping(value = "/project/{id}", produces = "application/json")
    public ResponseEntity<Project> setProjectVotability(@PathVariable Long id, boolean votable) {

        Project project = projectService.setProjectVotability(id, votable);

        return ResponseEntity.ok()
                .body(project);
    }
}

