package com.rest.voting.Project.voting.model;

import lombok.*;

import javax.persistence.Entity;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project extends BaseModel {
    /*
    fun fact - hibernate orders columns alphabetically, in database the
    description column will display before the name by default
     */
    private String name;
    private String description;
    private boolean votable;
}
