package com.rest.voting.Project.voting.services;

import com.rest.voting.Project.voting.model.Project;
import com.rest.voting.Project.voting.repositories.ProjectRepository;
import com.rest.voting.Project.voting.services.exceptions.ProjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProjectService {
    private ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getProjects() {
        return projectRepository.findAll(new Sort(Sort.Direction.ASC, "name"));
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElseThrow(() -> new ProjectException(id));
    }

    public Project setProjectVotability(Long id, boolean votable) {
        Project project = getProjectById(id);
        project.setVotable(votable);
        projectRepository.save(project);
        return project;
    }
}
