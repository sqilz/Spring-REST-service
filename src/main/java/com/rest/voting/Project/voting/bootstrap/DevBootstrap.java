package com.rest.voting.Project.voting.bootstrap;

import com.rest.voting.Project.voting.model.Project;
import com.rest.voting.Project.voting.model.Vote;
import com.rest.voting.Project.voting.model.Voter;
import com.rest.voting.Project.voting.repositories.ProjectRepository;
import com.rest.voting.Project.voting.repositories.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final ProjectRepository projectRepository;
    private final VoterRepository voterRepository;

    @Autowired
    public DevBootstrap(ProjectRepository projectRepository, VoterRepository voterRepository) {
        this.projectRepository = projectRepository;
        this.voterRepository = voterRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Project project = Project.builder()
                .name("FirstProject")
                .description("This is a first project")
                .votable(true).build();

        Project secondProject = Project.builder()
                .name("ASecondProject")
                .description("This is a second project")
                .votable(true).build();

        Project thirdProject = Project.builder()
                .name("BThirdProject")
                .description("This is a third project")
                .votable(true).build();

        Voter voter = Voter.builder().build();
        Voter voter2 = Voter.builder().build();

        projectRepository.save(project);
        projectRepository.save(secondProject);
        projectRepository.save(thirdProject);
        voterRepository.save(voter);
        voterRepository.save(voter2);
    }
}
