package com.rest.voting.Project.voting.services.exceptions;

public class VoteException extends RuntimeException {
    public VoteException(Long projectId ,Long voterId){
        super("Voter  " + voterId + ", has already voted for project " + projectId);
    }
}
