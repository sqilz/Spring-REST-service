package com.rest.voting.Project.voting.controllers;

import com.rest.voting.Project.voting.model.Project;
import com.rest.voting.Project.voting.model.Vote;
import com.rest.voting.Project.voting.repositories.ProjectRepository;
import com.rest.voting.Project.voting.repositories.VoteRepository;
import com.rest.voting.Project.voting.repositories.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class VoteController {
    @Autowired
    private VoterRepository voterRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private VoteRepository voteRepository;

    private String message;


    @RequestMapping(value = "/vote/{projectId}", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    String voteOnProject(@PathVariable Long projectId, Long voterId, boolean voteType) {
        Optional<Project> project = projectRepository.findById(projectId);
        project.ifPresent(project1 -> {
            boolean votable = project1.isVotable();
            if (votable) {
                voteRepository.save(new Vote(projectRepository.findById(projectId).get(), voterRepository.findById(voterId).get(), voteType));
                this.message = "Voter: " + voterId + " has voted for project: " + projectId;
            } else {
                this.message = "Project with id: " + projectId + " is not votable";
            }

        });
        return this.message;
    }
}
