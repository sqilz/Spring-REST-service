package com.rest.voting.Project.voting.repositories;

import com.rest.voting.Project.voting.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}
