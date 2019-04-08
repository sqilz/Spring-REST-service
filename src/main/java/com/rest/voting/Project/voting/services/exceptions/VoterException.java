package com.rest.voting.Project.voting.services.exceptions;

public class VoterException extends RuntimeException {
    public VoterException(Long voterId) {
        super("Project with id: " + voterId + " was not found");
    }
}
