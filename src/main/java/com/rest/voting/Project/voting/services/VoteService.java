package com.rest.voting.Project.voting.services;

import com.rest.voting.Project.voting.model.Project;
import com.rest.voting.Project.voting.model.Vote;
import com.rest.voting.Project.voting.model.Voter;
import com.rest.voting.Project.voting.repositories.ProjectRepository;
import com.rest.voting.Project.voting.repositories.VoteRepository;
import com.rest.voting.Project.voting.repositories.VoterRepository;
import com.rest.voting.Project.voting.services.exceptions.ProjectException;
import com.rest.voting.Project.voting.services.exceptions.VoteException;
import com.rest.voting.Project.voting.services.exceptions.VoterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteService {
    private final VoteRepository voteRepository;
    private final ProjectRepository projectRepository;
    private final VoterRepository voterRepository;

    @Autowired
    public VoteService(VoteRepository voteRepository, ProjectRepository projectRepository, VoterRepository voterRepository) {
        this.voteRepository = voteRepository;
        this.projectRepository = projectRepository;
        this.voterRepository = voterRepository;
    }

    public void vote(Long projectId, Long voterId, boolean voteType) {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new ProjectException(projectId));
        Voter voter = voterRepository.findById(voterId).orElseThrow(() -> new VoterException(voterId));
        voteRepository.voteExists(project, voter).ifPresent(s -> {
            throw new VoteException(projectId, voterId);
        });

        voteRepository.save(Vote.builder()
                .project(project)
                .voter(voter)
                .vote(voteType).build()
        );
    }
}
