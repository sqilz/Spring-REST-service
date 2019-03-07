package com.rest.voting.Project.voting.bootstrap;

import com.rest.voting.Project.voting.model.Project;
import com.rest.voting.Project.voting.repositories.ProjectRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private ProjectRepository projectRepository;

    public DevBootstrap(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Project project = new Project("FirstProject", "This is a first project");
        Project secondProject = new Project("ASecondProject", "This is a second project");
        Project thirdProject = new Project("BThirdProject", "This is a third project");

        projectRepository.save(project);
        projectRepository.save(secondProject);
        projectRepository.save(thirdProject);
    }
}
