package com.rest.voting.Project.voting.repositories;

import com.rest.voting.Project.voting.model.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}
