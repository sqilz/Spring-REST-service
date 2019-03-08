package com.rest.voting.Project.voting.controllers;

import com.rest.voting.Project.voting.model.Project;
import com.rest.voting.Project.voting.repositories.ProjectRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

//TODO - information if project is open for voting,
//TODO 	- and the number of votes for and against it
@Controller
public class ProjectController {
    private ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @RequestMapping(value = "/projects", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Project> getProjects() {
        List<Project> projects = projectRepository.findAll(new Sort(Sort.Direction.ASC, "name"));
        return projects;
    }


    @RequestMapping(value = "/projectt/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Optional<Project> getProjectById(@PathVariable Long id) {

        return projectRepository.findById(id);

    }
}

