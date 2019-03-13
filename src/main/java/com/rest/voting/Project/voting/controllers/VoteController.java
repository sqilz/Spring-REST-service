package com.rest.voting.Project.voting.controllers;

import com.rest.voting.Project.voting.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VoteController {
    private final VoteService voteService;

    @Autowired
    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping(value = "/vote/{projectId}", produces = "application/json")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void voteOnProject(@PathVariable Long projectId, Long voterId, boolean voteType) {
        voteService.vote(projectId, voterId, voteType);
    }
}
