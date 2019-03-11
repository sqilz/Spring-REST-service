package com.rest.voting.Project.voting.bootstrap;

import com.rest.voting.Project.voting.model.Project;
import com.rest.voting.Project.voting.model.Voter;
import com.rest.voting.Project.voting.repositories.ProjectRepository;
import com.rest.voting.Project.voting.repositories.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private VoterRepository voterRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Project project = new Project("FirstProject", "This is a first project", true);
        Project secondProject = new Project("ASecondProject", "This is a second project", true);
        Project thirdProject = new Project("BThirdProject", "This is a third project", true);

        Voter voter = new Voter();
        Voter voter2 = new Voter();

        projectRepository.save(project);
        projectRepository.save(secondProject);
        projectRepository.save(thirdProject);
        voterRepository.save(voter);
        voterRepository.save(voter2);
    }
}
