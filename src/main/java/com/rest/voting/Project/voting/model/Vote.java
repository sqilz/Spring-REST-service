package com.rest.voting.Project.voting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
