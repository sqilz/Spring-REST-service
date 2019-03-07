package com.rest.voting.Project.voting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /*
    fun fact - hibernate orders columns alphabetically, in database the
    description column will display before the name by default
     */
    private String name;
    private String description;

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
