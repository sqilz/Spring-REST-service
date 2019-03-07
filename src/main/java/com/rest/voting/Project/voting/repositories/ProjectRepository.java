package com.rest.voting.Project.voting.repositories;

import com.rest.voting.Project.voting.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {


}
