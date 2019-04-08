package com.rest.voting.Project.voting.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@Entity
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class Voter extends BaseModel {


}
