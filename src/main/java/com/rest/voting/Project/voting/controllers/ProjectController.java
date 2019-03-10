package com.rest.voting.Project.voting.controllers;

import com.rest.voting.Project.voting.model.Project;
import com.rest.voting.Project.voting.repositories.ProjectRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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


    @RequestMapping(value = "/project/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Optional<Project> getProjectById(@PathVariable Long id) {
        return projectRepository.findById(id);
    }

    @PatchMapping(value = "/project/{id}", produces = "application/json")
    public @ResponseBody
    String setProjectVotability(@PathVariable Long id, boolean votable) {
        Optional<Project> project = projectRepository.findById(id);
        project.ifPresent(project1 -> {
            project1.setVotable(votable);
        });
        project.ifPresent(project1 -> projectRepository.save(project1));

        return "Project with id:" + id + " votability has been set to " + votable;
    }


}

