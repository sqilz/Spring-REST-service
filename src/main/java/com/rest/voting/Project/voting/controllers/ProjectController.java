package com.rest.voting.Project.voting.controllers;

import com.rest.voting.Project.voting.model.Project;
import com.rest.voting.Project.voting.repositories.ProjectRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProjectController {
    private ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @RequestMapping(value = "/projects", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Project> getProjects(Model model) {
        List<Project> projects = (List<Project>) projectRepository.findAll();

        return projects;
    }

}
