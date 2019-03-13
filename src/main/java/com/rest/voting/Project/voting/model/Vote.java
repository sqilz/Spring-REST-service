package com.rest.voting.Project.voting.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Vote extends BaseModel {
    @ManyToOne
    private Project project;
    @ManyToOne
    private Voter voter;

    private boolean vote;


}
