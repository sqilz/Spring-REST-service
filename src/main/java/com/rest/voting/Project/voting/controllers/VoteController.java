package com.rest.voting.Project.voting.controllers;

import com.rest.voting.Project.voting.model.Vote;
import com.rest.voting.Project.voting.repositories.ProjectRepository;
import com.rest.voting.Project.voting.repositories.VoteRepository;
import com.rest.voting.Project.voting.repositories.VoterRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VoteController {
    private VoterRepository voterRepository;
    private ProjectRepository projectRepository;
    private VoteRepository voteRepository;

    public VoteController(VoterRepository voterRepository, ProjectRepository projectRepository, VoteRepository voteRepository) {
        this.voterRepository = voterRepository;
        this.projectRepository = projectRepository;
        this.voteRepository = voteRepository;
    }

    @RequestMapping(value = "/vote", method = RequestMethod.GET, produces = "application/json")
    public HttpStatus voteOnProject() {
        voteRepository.save(new Vote(projectRepository.findById(1L).get(), voterRepository.findById(1L).get(), true));
      return HttpStatus.OK;

    }
}
