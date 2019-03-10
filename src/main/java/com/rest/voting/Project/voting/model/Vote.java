package com.rest.voting.Project.voting.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Optional;

@Data
@AllArgsConstructor
@Entity
public class Vote {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Project project;
    @ManyToOne
    private Voter voter;

    private boolean vote;

    public Vote(Project project, Voter voter, boolean vote) {
        this.project = project;
        this.voter = voter;
        this.vote = vote;
    }


}
