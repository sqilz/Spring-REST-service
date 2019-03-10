package com.rest.voting.Project.voting.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Voter {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;


}
