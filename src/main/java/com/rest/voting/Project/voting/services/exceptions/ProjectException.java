package com.rest.voting.Project.voting.services.exceptions;

public class ProjectException extends RuntimeException {

  public ProjectException(Long projectId) {
    super("Project with id: " + projectId + " was not found");
  }
}
