package com.rest.voting.Project.voting.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Voter {
    @Id
    @GeneratedValue
    private Long id;
}
