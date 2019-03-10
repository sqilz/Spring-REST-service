package com.rest.voting.Project.voting.repositories;

import com.rest.voting.Project.voting.model.Voter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoterRepository extends JpaRepository<Voter, Long> {
}
