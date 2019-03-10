package com.rest.voting.Project.voting.bootstrap;

import com.rest.voting.Project.voting.model.Project;
import com.rest.voting.Project.voting.model.Vote;
import com.rest.voting.Project.voting.model.Voter;
import com.rest.voting.Project.voting.repositories.ProjectRepository;
import com.rest.voting.Project.voting.repositories.VoteRepository;
import com.rest.voting.Project.voting.repositories.VoterRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private ProjectRepository projectRepository;
    private VoterRepository voterRepository;
    private VoteRepository voteRepository;

    public DevBootstrap(ProjectRepository projectRepository, VoterRepository voterRepository) {
        this.projectRepository = projectRepository;
        this.voterRepository = voterRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Project project = new Project("FirstProject", "This is a first project");
        Project secondProject = new Project("ASecondProject", "This is a second project");
        Project thirdProject = new Project("BThirdProject", "This is a third project");

        Voter voter = new Voter();

        projectRepository.save(project);
        projectRepository.save(secondProject);
        projectRepository.save(thirdProject);
        voterRepository.save(voter);
    }
}
