package com.rest.voting.Project.voting.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Voter {
    @Id
    @GeneratedValue
    private Long id;


}
